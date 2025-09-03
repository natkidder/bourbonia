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
import { z } from "zod";
import { parseISO, parse, lastDayOfMonth, format } from "date-fns";
import Sandbox from "./Sandbox";

const Cnts = ["0", "6", "8", "12", "18", "24", "30", "36", "48"] as const;
const States = ["", "FL", "GA", "NC", "SC", "VA"] as const; // Use 'as const'
const orderStatuses = ["New", "In Process", "Cancelled", "Completed"] as const;

function IndivCannedFruit(props2) {
  return (
    <tr>
      <td> {props2.id} </td>
      <td> {props2.fruit} </td>
      <td> {props2?.medium?.mediumName}</td>
      <td> {props2.unitType}</td>
      <td> {props2.volume}</td>
      <td> {props2.container}</td>
      <td>
        {" "}
        <CurrencyDisplay amount={props2.pricePer} />
      </td>
      <td>
        {" "}
        <select id="cnt" name={`${props2.id}`}>
          {Cnts.map((cnt) => (
            <option key={cnt} value={cnt}>
              {cnt}
            </option>
          ))}
        </select>{" "}
      </td>
    </tr>
  );
}

function IndivShipping(props2) {
  return (
    <tr>
      <td> {props2.id} </td>
      <td> {props2.type} </td>
      <td> ${props2.price}</td>
      <td>
        {" "}
        <input type="radio" name="updShippingRadios" value={props2.id} />{" "}
      </td>
    </tr>
  );
}

// TODO make it a zod form
function HomePage(props) {
  var [containerCnt, setContainerCnt] = useState(0);
  const ordCannedFruits = props.ordCannedFruits;
  const customer = props.customer;
  const shippings = props.shippings;
  const [inputs, setInputs] = useState({});
  const [selectedShipping, setSelectedShipping] = useState("");
  const [nameOnCard, setNameOnCard] = useState("");
  const [cardNbr, setCardNbr] = useState("");
  const [expirationMthYr, setExpirationMthYr] = useState("");
  const [expirationDt, setExpirationDt] = useState("");

  const formatCardNbr = (value) => {
    // Remove all non-digit characters
    const rawText = value.replace(/\D/g, "");
    // Add a space every four digits for formatting
    const formattedText = rawText.match(/.{1,4}/g)?.join(" ") || "";
    // Limit the length to 19 characters (16 digits + 3 spaces)
    return formattedText.slice(0, 19);
  };
  const handleCardNbrChange = (e) => {
    const { value } = e.target;
    setCardNbr(formatCardNbr(value));
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    const formData = new FormData(event.target);
    let values = JSON.stringify(Object.fromEntries(formData.entries()));
    let json = JSON.parse(values);
    console.log(json); ///////
  };
  const handleExDtChange = (e) => {
    const { mmYYString } = e.target;
    const parsedDate = parse(mmYYString, "MM/yy", new Date()); // Parse MM/YY
    const lastDay = lastDayOfMonth(parsedDate); // Get last day of the month
    const formattedDate = format(lastDay, "yyyy-MM-dd"); // Format as desired
    setExpirationDt(formattedDate);
  };

  return (
    <>
      <form onSubmit={handleSubmit}>
        <h1>Canned Fruit</h1>
        <h2>Select Count of Each Offering</h2>
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
              <th>Order?</th>
            </tr>
          </thead>
          <tbody>
            {ordCannedFruits.map((cannedFruit) => (
              <IndivCannedFruit
                id={cannedFruit.id}
                fruit={cannedFruit.fruit}
                medium={cannedFruit.medium}
                unitType={cannedFruit.unitType}
                volume={cannedFruit.volume}
                container={cannedFruit.container}
                pricePer={cannedFruit.pricePer}
              />
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
              <td> {customer.id} </td>
              <td> {customer.businessName} </td>
              <td> {customer.outletName}</td>
              <td>
                {" "}
                {customer.pocFirst} {customer.pocLast}
              </td>
              <td>{customer.pocPhone}</td>
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
              <th>Ship To?</th>
            </tr>
          </thead>
          <tbody>
            {customer.addresses.map((a) => (
              <tr>
                <td>{a.id}</td>
                <td>{a.addrType}</td>
                <td>
                  {a.street1} {a.street2}
                  <br />
                  {a.city}, {a.state} {a.zip}
                </td>
                <td>
                  {" "}
                  <input
                    type="radio"
                    name="updShipToRadios"
                    value={a.id}
                  />{" "}
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
              <th>Price</th>
              <th>Update?</th>
            </tr>
          </thead>
          <tbody>
            {shippings.map((shipping) => (
              <IndivShipping
                id={shipping.id}
                type={shipping.type}
                price={shipping.price}
                selectedOption={selectedShipping}
              />
            ))}
          </tbody>
        </table>
        <br />
        <label>
          Name on Card:
          <input type="text" name="nameOnCard" value={nameOnCard || ""} />
          &nbsp;
        </label>
        <label>
          Card Nbr:
          <input
            type="text"
            value={cardNbr || ""}
            onChange={handleCardNbrChange}
            placeholder="xxxx xxxx xxxx xxxx"
          />
          &nbsp;
        </label>
        <label>
          Expiration (MM/YY):
          <input
            type="text"
            value={expirationMthYr || ""}
            onChange={handleExDtChange}
            placeholder="xxxx xxxx xxxx xxxx"
          />
          &nbsp;
        </label>
        <input type="submit" value="Send Order" />
      </form>
      <br />
      <Link to="/">Back to Home</Link>
    </>
  );
}

export default HomePage;

/*
      <Link to="/">Back to Home</Link>
  "54",
  "72",
  "96",
  "108",
  "144",
  "192",
*/
/* //==zod schema
  const MediumSchema = z.object({
  mediumName: z.string().min(1, "Medium is required"),
});
const CannedFruitSchema = z.object({
  fruit: z.string(),
  volume: z.number().int().positive(),
  container: z.string(),
  pricePer: z
    .number()
    .refine(
      (val) => Number.isInteger(val * 100),
      "Currency must have at most two decimal places"
    ),
  unitType: z.string(),
  medium: MediumSchema,
});
const CustomerOrderItemSchema = z.object({
  cannedFruit: CannedFruitSchema,
  cnt: z.enum(Cnts),
});
const AddressSchema = z.object({
  addrType: z.string().min(1, "Address Type is Required"),
  street1: z.string().min(1, "Street 1 is required"),
  street2: z.string(),
  city: z.string().min(1, "City is required"),
  state: z.enum(States),
  zip: z.string().regex(/^\d{5}$/, "Invalid Zip Code"),
});

const CustomerSchema = z.object({
  businessName: z
    .string()
    .min(1, "BusinessName must be at least 3 characters long"),
  outletName: z.string().min(1, "Invalid outletName address"),
  pocFirst: z
    .string()
    .min(1, "POC First Nm must be at least 6 characters long"),
  pocLast: z.string().min(1, "POC First Nm must be at least 6 characters long"),
  pocPhone: z
    .string()
    .min(10, "Phone number must be at least 10 digits long")
    .max(15, "Phone number cannot exceed 15 digits")
    .regex(/^\d{3}-{0,1}\d{3}-{0,1}\d{4}/, "Invalid phone number format") // Example regex for international numbers
    .transform((value) => value.replace(/\D/g, "")), // Optional: Remove non-digits for storage
  pocEmail: z.email("Invalid Email Address").min(1,"Email required"),
  addresses: z.array(AddressSchema), // Array of nested schemas
});

const ShippingSchema = z.object({
  type: z.string().min(1,"Type is required"),
  price: z.number()
    .refine(
      (val) => Number.isInteger(val * 100),
      "Currency must have at most two decimal places"
    ),
})

const CustomerOrderSchema = z.object({
  customer: CustomerSchema,
  nameOnCard: z.string().regex(/^[A-Z0-9]{1,}\s[A-Z0-9]{1,}$/,"Invalid name on card"),
  cardNbr: z.string().regex(/^\d{16}$/,"Invalid credit card number"),
  expirationDt: z.string().regex(/[01]{1}\d{1}\/\d{2}/,"Expiration Date should be in an MM/YY format"),
  cvv: z.string().regex(/\d{3}/, "Invalid CVV"),
  orderStatus: z.enum(orderStatuses),
  customerOrderItems: z.array(CustomerOrderItemSchema),
  shipping: ShippingSchema,
  shipToAddress: AddressSchema,
})

const cannedFruitArray = z.array(CustomerOrderItemSchema); */
