import React from "react";
import { useState, useEffect } from "react";
import ReactDOM from "react-dom/client";
import createRoot from "react-dom/client";
import "../customer-list/CustomerList.css";
import CurrencyDisplay from "../utils/CurrencyDisplay";
import PhoneDisplay from "../utils/PhoneDisplay";
import { Link, MemoryRouter } from "react-router-dom";
import { useForm, useFieldArray } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { set, z } from "zod";
import { parseISO, parse, lastDayOfMonth, format } from "date-fns";
import CustomerOrderSvc from "../customerOrder-list/CustomerOrderSvc.tsx";
import {
  Cnts,
  States,
  orderStatuses,
  customerOrderItems,
  updOCF,
  removeExtraneousCannedFruit,
  removeExtraneousSTAF,
  removeExtraneousShipping,
  reconstructOrder,
  enableSubmit,
  calcTotalCosts,
} from "./CustomerOrderAddUtil.tsx";

//==zod schema
const MediumSchema = z.object({
  id: z.number().int().positive(),
  mediumName: z.string().min(1, "Medium is required"),
});
const CannedFruitSchema = z.object({
  id: z.number().int().positive(),
  fruit: z.string(),
  volume: z.number().int().positive(),
  container: z.string(),
  pricePer: z.number(),
  unitType: z.string(),
  medium: MediumSchema,
});
const CustomerOrderItemSchema = z.object({
  cannedFruit: CannedFruitSchema,
  cnt: z.enum(Cnts),
});
const AddressSchema = z.object({
  id: z.number().int().positive(),
  addrType: z.string().min(1, "Address Type is Required"),
  street1: z.string().min(1, "Street 1 is required"),
  street2: z.string(),
  city: z.string().min(1, "City is required"),
  state: z.enum(States),
  zip: z.string().regex(/^\d{5}$/, "Invalid Zip Code"),
});

const CustomerSchema = z.object({
  id: z.number().int().positive(),
  businessName: z.string().min(1, "BusinessName must be at least 3 characters long"),
  outletName: z.string().min(1, "Invalid outletName address"),
  pocFirst: z.string().min(1, "POC First Nm must be at least 6 characters long"),
  pocLast: z.string().min(1, "POC First Nm must be at least 6 characters long"),
  pocPhone: z
    .string()
    .min(10, "Phone number must be at least 10 digits long")
    .max(15, "Phone number cannot exceed 15 digits")
    .regex(/^\d{3}-{0,1}\d{3}-{0,1}\d{4}/, "Invalid phone number format") // Example regex for international numbers
    .transform((value) => value.replace(/\D/g, "")), // Optional: Remove non-digits for storage
  pocEmail: z.email("Invalid Email Address").min(1, "Email required"),
  addresses: z.array(AddressSchema), // Array of nested schemas
});

const ShippingSchema = z.object({
  id: z.number().int().positive(),
  type: z.string().min(1, "Type is required"),
  price: z.number().refine((val) => Number.isInteger(val * 100), "Currency must have at most two decimal places"),
});

const CustomerOrderSchema = z.object({
  customer: CustomerSchema,
  nameOnCard: z.string(),
  cardNbr: z
    .string()
    .min(13, "Card Number must be at least 13 digits")
    .max(19, "Card Number cannot exceed 19 digits")
    .regex(/^\d{13,19}$/, { message: "Card Number must be numeric only" }), // Simple regex for numeric check
  expirationDt: z.string().regex(/[01]{1}\d{1}\/\d{2}/, {
    message: "Expiration Date should be in an MM/YY format",
  }),
  cvv: z.string().regex(/\d{3,4}/, { message: "Invalid CVV" }),
  orderStatus: z.enum(orderStatuses),
  customerOrderItems: z.array(CustomerOrderItemSchema),
  shipping: ShippingSchema,
  shipToAddress: AddressSchema,
});

// TODO make it a zod form
function CustomerOrderAdd(props) {
  //console.log("ordCannedFruits10", customerOrderItems(props.ordCannedFruits)); ///////
  //const [ordCannedFruits, setOrdCannedFruits] = useState(customerOrderItems(props.ordCannedFruits));
  const ordCannedFruits = customerOrderItems(props.ordCannedFruits);
  const [ordCannedFruits02, setOrdCannedFruits02] = useState(customerOrderItems(props.ordCannedFruits));
  const customer = props.customer;
  const shippings = props.shippings;
  //console.log("shippings", shippings); //////
  const [selectedShipping, setSelectedShipping] = useState("");
  const validDataCustomer = CustomerSchema.safeParse(customer).success; /////
  const {
    register,
    handleSubmit,
    control,
    reset,
    setValue,
    formState: { errors },
  } = useForm({
    resolver: zodResolver(CustomerOrderSchema),
  });
  const { fields, append, remove } = useFieldArray({
    control,
    name: "customerOrderItems",
  });
  setValue(`customer.id`, customer.id);
  setValue(`orderStatus`, "New");
  let customerOrder = {};
  let shipToAddress = { shipToAddress: { id: 0 } };
  var [shipToAddress02, setShipToAddress02] = useState({}); //{shipToAddress: {id: 0}});
  //let selectedItem = customer.addresses[0];
  let shipToAddresses = customer.addresses;
  let shippingPrice = -1.0;
  var [shippingPrice02, setShippingPrice02] = useState(-1.0);
  let shipToState = "";
  var [shipToState02, setShipToState02] = useState("");
  let newOCF = [];
  var [newOCF02, setNewOCF02] = useState([{ cannedFruit: { id: 0 }, cnt: "0" }]);
  var [totalCosts, setTotalCosts] = useState(0);
  //console.log("shipToAddresses", shipToAddresses); //////
  let shipping = { shipping: { id: 0 } };
  var [shipping02, setShipping02] = useState({}); //{shipping: {id: 0}});
  let selectedItemShipping = shippings[0];
  let nameOnCard = "";
  let cardNbr = ""; // should be string to preserve leading zeros
  let expirationDt = ""; // should be string in MM/YY format
  let cvv = ""; // should be string to preserve leading zeros
  var [submitFormEnabled, setSubmitFormEnabled] = useState(false);

  const handleChangeCF = (e, index) => {
    console.log("handleChangeCF00", ordCannedFruits02);
    const { name, value } = e.target;
    var newItemsOCF = [...ordCannedFruits];
    newItemsOCF = updOCF(newItemsOCF, newOCF02, index, name, value);
    //console.log("handleChangeCF02 index, name, value", index, name, value); //////
    console.log("handleChangeCF04 newItemsOCF", newItemsOCF); //////
    newItemsOCF[index][name] = value;
    //console.log("handleChangeCF05 newItemsOCF", newItemsOCF); //////
    newOCF = removeExtraneousCannedFruit(newItemsOCF);
    setNewOCF02(newOCF);
    //console.log("handleChangeCF10", ordCannedFruits); ///////
    //setOrdCannedFruits02(newItemsOCF);
    //console.log("handleChangeCF20 newOCF", ordCannedFruits02); //////
    setTotalCosts(calcTotalCosts(ordCannedFruits02, newOCF, shippingPrice02, shipToState02));
    //console.log("handlChangeCF10", ordCannedFruits);
  };
  const handleChangeSTA = async (e, index) => {
    const { name, value } = e.target;
    const newItemsSTA = [...shipToAddresses];
    newItemsSTA[index][name] = value;
    let selectedItemSTA = JSON.parse(JSON.stringify(newItemsSTA[index])); // deep clone
    let shipToState = selectedItemSTA.state ? selectedItemSTA.state : "";
    setShipToState02(shipToState);
    //console.log("shipToState:", shipToState); ///////
    removeExtraneousSTAF(selectedItemSTA);
    //console.log("handleChangeSTA shipToAddress", shipToAddress); ///////
    shipToAddress.shipToAddress.id = selectedItemSTA.id;
    setShipToAddress02(shipToAddress);
    setSubmitFormEnabled(enableSubmit(shipToAddress, shipping02, nameOnCard, cardNbr, expirationDt, cvv));
    setTotalCosts(calcTotalCosts(ordCannedFruits02, newOCF02, shippingPrice02, shipToState));
    //customerOrder.shipToAddress = shipToAddress.shipToAddress
    //console.log("12", customerOrder); ///////
  };
  const handleChangeShipping = async (e, index) => {
    const { name, value } = e.target;
    const newItemsShipping = [...shippings];
    newItemsShipping[index][name] = value;
    selectedItemShipping = JSON.parse(JSON.stringify(newItemsShipping[index])); // deep clone
    let shippingPrice = selectedItemShipping ? selectedItemShipping.price : -1;
    setShippingPrice02(shippingPrice);
    removeExtraneousShipping(selectedItemShipping);
    //console.log("selectedItemShipping after removeExtraneousShipping:", selectedItemShipping); ///////
    //console.log("handle changeShipping 10", shipping); ///////
    shipping.shipping.id = selectedItemShipping.id;
    setShipping02(shipping);
    //console.log("handle changeShipping 20", shipping); ///////
    setTotalCosts(calcTotalCosts(ordCannedFruits02, newOCF02, shippingPrice, shipToState02));
    setSubmitFormEnabled(enableSubmit(shipToAddress02, shipping, nameOnCard, cardNbr, expirationDt, cvv));
    //console.log("handle changeShipping 30", shipping); ///////
  };
  const handleChangeNameOnCard = (e) => {
    nameOnCard = e.target.value;
    setSubmitFormEnabled(enableSubmit(shipToAddress02, shipping02, nameOnCard, cardNbr, expirationDt, cvv));
  };
  const handleChangeCardNbr = (e) => {
    cardNbr = e.target.value;
    setSubmitFormEnabled(enableSubmit(shipToAddress02, shipping02, nameOnCard, cardNbr, expirationDt, cvv));
  };
  const handleChangeExpirationDt = (e) => {
    expirationDt = e.target.value;
    setSubmitFormEnabled(enableSubmit(shipToAddress02, shipping02, nameOnCard, cardNbr, expirationDt, cvv));
  };
  const handleChangeCvv = (e) => {
    cvv = e.target.value;
    setSubmitFormEnabled(enableSubmit(shipToAddress02, shipping02, nameOnCard, cardNbr, expirationDt, cvv));
    //console.log("after handleChangeCvv submitFormEnabled", submitFormEnabled); ///////
    //console.log("after handleChangeCvv shipToAddress02", shipToAddress02); ///////
  };

  const handleForm = async (event) => {
    event.preventDefault();
    //console.log("handleForm 01 shipToAddress02", shipToAddress02); ////////
    //console.log("handlForm 01 shipping", shipping); ////////
    const formData = new FormData(event.target);
    let values = JSON.stringify(Object.fromEntries(formData.entries()));
    let inputs = JSON.parse(values);
    console.log("handleForm inputs", inputs); ////////
    console.log("handleForm ordCannedFruits", ordCannedFruits); ////////
    console.log("handleForm ordCannedFruits02", ordCannedFruits02); ////////
    console.log("handleForm newOCF02", newOCF02); ////////
    inputs.customerOrderItems = newOCF02.map((item) => ({
      cannedFruit: {
        id: item.cannedFruit.id,
      },
      cnt: item.cnt, // Use the selected count
    }));
    console.log("inputs after customerOrderItems", inputs); ////////
    //console.log("handleForm 02 shipToAddress", shipToAddress02); ////////
    //console.log("handlForm 02 shipping", shipping02); ////////
    let inputs2 = reconstructOrder(inputs);
    console.log("final inputs", inputs2); ////////
    const response = await fetch("http://localhost:8081/api2/customerOrder", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(inputs2),
    });
    if (response.ok) {
      const data = await response.json();
      console.log("Success:", data);
      console.log("data.id", data.id); ///////
      alert("Order " + data.id + " successfully created!");
      //window.location.href = "http://localhost:3000"; // Redirect to home page
    } else {
      console.error("Error:", response.statusText);
      alert("Failed to create order. Please try again.");
    }
  };

  return (
    <>
      <p />
      {/*<form onSubmit={handleSubmit(onSubmit)}>*/}
      <form onSubmit={handleForm}>
        <br />
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Fruit</th>
              <th>Medium</th>
              <th>Preparation</th>
              <th>Volume (Oz)</th>
              <th>Container</th>
              <th>Price per Oz</th>
              <th>Cnt</th>
            </tr>
          </thead>
          <tbody>
            {ordCannedFruits.map((item, index) => (
              <tr key={index}>
                <td> {item.cannedFruit.id}</td>
                <td> {item.cannedFruit.fruit}</td>
                <td> {item.cannedFruit.medium ? item.cannedFruit.medium.mediumName : ""}</td>
                <td> {item.cannedFruit.unitType}</td>
                <td> {item.cannedFruit.volume}</td>
                <td> {item.cannedFruit.container}</td>
                <td>
                  {" "}
                  <CurrencyDisplay amount={item.cannedFruit.pricePer} />
                </td>
                <td>
                  {" "}
                  <select id="cnt" name="cnt" onChange={(e) => handleChangeCF(e, index)}>
                    {Cnts.map((cnt) => (
                      <option key={cnt} value={cnt}>
                        {cnt}
                      </option>
                    ))}
                  </select>{" "}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
        <h1>Customer</h1>
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Business</th>
              <th>Outlet</th>
              <th>POC</th>
              <th>POC Phone</th>
              <th>Email</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>
                {" "}
                <input type="text" name="customer_id" value={customer.id} size={5} readOnly className="read-only" />{" "}
              </td>
              <td> {customer.businessName} </td>
              <td> {customer.outletName}</td>
              <td>
                {" "}
                {customer.pocFirst} {customer.pocLast}
              </td>
              <td>
                <PhoneDisplay phoneNbr={customer.pocPhone} />
              </td>
              <td> {customer.pocEmail}</td>
            </tr>
          </tbody>
        </table>
        <h2>Select Ship To Address</h2>
        <table>
          <thead>
            <tr>
              <th>id</th>
              <th>Type</th>
              <th>Address</th>
              <th> </th>
            </tr>
          </thead>
          <tbody>
            {customer.addresses.map((a, index) => (
              <tr key={index}>
                <td>{a.id}</td>
                <td>{a.addrType}</td>
                <td>
                  {a.street1} {a.street2}
                  <br />
                  {a.city}, {a.state} {a.zip}
                </td>
                <td>
                  {" "}
                  <input type="radio" name="shipToAddress_id" value={a.id} onChange={(e) => handleChangeSTA(e, index)} />{" "}
                </td>
              </tr>
            ))}
          </tbody>
        </table>{" "}
        <h1>Shipping Terms</h1>
        <h2>Select Shipping Terms</h2>
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Type</th>
              <th>Price Per Oz</th>
              <th> </th>
            </tr>
          </thead>
          <tbody>
            {shippings.map((a, index) => (
              <tr key={index}>
                <td>{a.id}</td>
                <td>{a.type}</td>
                <td>
                  <CurrencyDisplay amount={a.price} />
                </td>
                <td>
                  {" "}
                  <input type="radio" name="shipping_id" value={a.id} onChange={(e) => handleChangeShipping(e, index)} />{" "}
                </td>
              </tr>
            ))}{" "}
          </tbody>
        </table>
        <h1>Payment Info</h1>
        <br />
        <label htmlFor="nameOnCard">Name on Card:</label>
        <input {...register("nameOnCard")} placeholder="Name on Card" onChange={(e) => handleChangeNameOnCard(e)} />
        {errors.nameOnCard && <p>{errors.nameOnCard.message}</p>}&nbsp;
        <label htmlFor="cardNbr">Card Number:</label>
        <input {...register("cardNbr")} type="cardNbr" placeholder="xxxx xxxx xxxx xxxx" onChange={(e) => handleChangeCardNbr(e)} />
        {errors.cardNbr && <p>{errors.cardNbr.message}</p>}
        <br />
        <label htmlFor="expirationDt">Valid Thru (MM/YY):</label>
        <input {...register("expirationDt")} placeholder="MM/YY" onChange={(e) => handleChangeExpirationDt(e)} />
        {errors.expirationDt && <p>{errors.expirationDt.message}</p>}&nbsp;
        <label htmlFor="cvv">CVV:</label>
        <input {...register("cvv")} placeholder="xxx" type="password" onChange={(e) => handleChangeCvv(e)} />
        {errors.cvv && <p>{errors.cvv.message}</p>}&nbsp;
        <input {...register("orderStatus")} hidden />
        <br />
        {/*<p>{submitFormEnabled.toString()}</p>*/}
        Total Cost: <CurrencyDisplay amount={totalCosts} />
        <br />
        <input type="submit" value="Send Order" disabled={!submitFormEnabled} />
      </form>
      <a href="http://localhost:3000">Back to Home</a>
      <p />
    </>
  );
}

export default CustomerOrderAdd;

/*
.regex(/^[A-Z0-9]{1,}\s[A-Z0-9]{1,}$/, "Invalid name on card")
          {fields.map((field, index) => {
            return (
            <tr key={field.id}>
                <td><input {...register(`customerOrderItems.${index}.cnt`)} placeholder="customerOrderItems.cnt" readOnly className="read-only" /></td>
                </tr>
                )
              }
      .refine(
      (val) => Number.isInteger(val * 100),
      "Currency must have at most two decimal places"
    )
    onChange={(e) => handleChange(e, index)} */
/*    ordCannedFruits.map(
  (item, index) => (
    setValue(`customerOrderItems.${index}.cannedFruit.id`, item.id),
    setValue(`customerOrderItems.${index}.cannedFruit.fruit`, item.fruit),
    setValue(`customerOrderItems.${index}.cannedFruit.volume`, item.volume),
    setValue(
      `customerOrderItems.${index}.cannedFruit.container`,
      item.container
    ),
    setValue(
      `customerOrderItems.${index}.cannedFruit.pricePer`,
      item.pricePer
    ),
    setValue(
      `customerOrderItems.${index}.cannedFruit.unitType`,
      item.unitType
    ),
    setValue(
      `customerOrderItems.${index}.cannedFruit.medium.mediumName`,
      item.medium?.mediumName
    )
  )
);
} */

/*
const onSubmit = async (inputs) => {
  alert("handleSubmit(onSubmit)"); ////////
  //event.preventDefault();
  //console.log(inputs);
};
*/
