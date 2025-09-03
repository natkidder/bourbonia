import React from "react";
import { useState, useEffect } from "react";
import ReactDOM from "react-dom/client";
import createRoot from "react-dom/client";
import "../customer-list/CustomerList.css";
//import CustomerSvc from "../customer-list/CustomerSvc";
import PhoneDisplay from "../utils/PhoneDisplay";
import { Link, MemoryRouter, BrowserRouter } from "react-router-dom";
import { useForm, useFieldArray } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { z } from "zod";
import CustomerSvc from "../customer-list/CustomerSvc";
import ShippingRoute2 from "../shipping-route/ShippingRoute2.tsx";

const States = ["", "FL", "GA", "NC", "SC", "VA"] as const; // Use 'as const'
const AddrSchema = z.object({
  addrType: z.string().min(1, "Address Type is Required"),
  street1: z.string().min(1, "Street 1 is required"),
  street2: z.string(),
  city: z.string().min(1, "City is required"),
  state: z.enum(States),
  zip: z.string().regex(/^\d{5}$/, "Invalid Zip Code"),
});

const CustomerSchema = z.object({
  id: z.number().int().positive(),
  businessName: z.string().min(1, "BusinessName must be present"),
  outletName: z.string().min(1, "Outlet Name must be present"),
  pocFirst: z.string().min(1, "POC First Nm must be at least 6 characters long"),
  pocLast: z.string().min(1, "POC First Nm must be at least 6 characters long"),
  pocPhone: z
    .string()
    .min(10, "Phone number must be at least 10 digits long")
    .max(15, "Phone number cannot exceed 15 digits")
    .regex(/^\d{3}-{0,1}\d{3}-{0,1}\d{4}/, "Invalid phone number format") // Example regex for international numbers
    .transform((value) => value.replace(/\D/g, "")), // Optional: Remove non-digits for storage
  pocEmail: z.email("Invalid Email Address"),
  addresses: z.array(AddrSchema), // Array of nested schemas
});

function IndivCustomer(props2) {
  return (
    <tr>
      <td> {props2.id} </td>
      <td> {props2.businessName} </td>
      <td> {props2.outletName} </td>
      <td>
        {" "}
        {props2.pocFirst} {props2.pocLast}{" "}
      </td>
      <td>
        {" "}
        <PhoneDisplay phoneNbr={props2.pocPhone} />{" "}
      </td>
      <td> {props2.pocEmail} </td>
      <td>
        {" "}
        {props2.addresses.map((a) => (
          <div>
            <b>{a.addrType}</b>
            <br />
            {a.street1} {a.street2}
            <br />
            {a.city}, {a.state} {a.zip}
          </div>
        ))}
      </td>
      <td>
        {" "}
        <input type="radio" name="updRadios" value={props2.id} />{" "}
      </td>
    </tr>
  );
}

function CustomerUpd(props) {
  const [inputs, setInputs] = useState({});
  //const onSubmit = (data) => console.log(data);
  const customers = props.customers;

  const {
    register,
    handleSubmit,
    control,
    reset,
    formState: { errors },
  } = useForm({
    resolver: zodResolver(CustomerSchema),
  });
  const { fields, append, remove } = useFieldArray({
    control,
    name: "addresses",
  });

  const handleChoice = async (event) => {
    event.preventDefault();
    const formData = new FormData(event.target);
    let values = JSON.stringify(Object.fromEntries(formData.entries()));
    let json = JSON.parse(values);
    var data = "";
    try {
      const response = await fetch("http://localhost:8081/api2/customer/" + json.updRadios, {
        method: "GET",
      });
      if (response.ok) {
        let data = await response.json();
        setInputs(data);
        reset(data); // map the data to the form
      } else {
        console.error("Error:", response.status);
      }
    } catch (error) {
      console.error("Error:", error);
    }
  };
  const onSubmit = async (inputs) => {
    //event.preventDefault();
    console.log(inputs);
    try {
      const response = await fetch("http://localhost:8081/api2/customer/" + inputs.id, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(inputs),
      });

      if (response.ok) {
        const data = await response.json();
        console.log("Success:", data);
      } else {
        console.error("Error:", response.status);
      }
    } catch (error) {
      console.error("Error:", error);
    }
    const root = ReactDOM.createRoot(document.getElementById("root") as Element);
    root.render(
      <MemoryRouter>
        <CustomerSvc child="CustomerUpd" businessName={props.businessName} outletName={props.outletName} pocFirst={props.pocFirst} pocLast={props.pocLast} />
      </MemoryRouter>
    );
    //window.location.reload();  //TODO added to make link work; try to find a cheaper way
  };
  const handleRouter = () => {
    let root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <BrowserRouter>
        <ShippingRoute2 />
      </BrowserRouter>
    );
  };

  return (
    <>
      <form onSubmit={handleChoice}>
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Business</th>
              <th>Outlet</th>
              <th>POC</th>
              <th>POC Phone</th>
              <th>Email</th>
              <th>Addresses</th>
              <th>Upd?</th>
            </tr>
          </thead>
          <tbody>
            {customers.map((customer) => (
              <IndivCustomer
                id={customer.id}
                businessName={customer.businessName}
                outletName={customer.outletName}
                pocFirst={customer.pocFirst}
                pocLast={customer.pocLast}
                pocPhone={customer.pocPhone}
                pocEmail={customer.pocEmail}
                addresses={customer.addresses}
              />
            ))}
          </tbody>
        </table>
        <input type="submit" />
      </form>
      <p></p>
      <form onSubmit={handleSubmit(onSubmit)}>
        <label htmlFor="id">ID:</label>
        <input {...register("id")} placeholder="id" readOnly className="read-only" />
        <br />
        <label htmlFor="businessName">Business:</label>
        <input {...register("businessName")} placeholder="Business" />
        {errors.businessName && <p>{errors.businessName.message}</p>}&nbsp;
        <label htmlFor="outletName">Outlet:</label>
        <input id="outletName" {...register("outletName")} />
        {errors.outletName && <span>{errors.outletName.message}</span>}&nbsp;
        <label htmlFor="pocFirst">POC First Nm:</label>
        <input id="pocFirst" type="pocFirst" {...register("pocFirst")} size={10} />
        &nbsp;
        {errors.pocFirst && <span>{errors.pocFirst.message}</span>}
        <label htmlFor="pocLast">POC Last Nm:</label>
        <input id="pocLast" type="pocLast" {...register("pocLast")} size={10} />
        {errors.pocLast && <span>{errors.pocLast.message}</span>}
        <br />
        <label htmlFor="pocPhone">POC Phone:</label>
        <input id="pocPhone" type="pocPhone" {...register("pocPhone")} />
        {errors.pocPhone && <span>{errors.pocPhone.message}</span>}&nbsp;
        <label htmlFor="pocEmail">POC Email:</label>
        <input id="pocEmail" type="pocEmail" {...register("pocEmail")} />
        {errors.pocEmail && <span>{errors.pocEmail.message}</span>}
        <p />
        {fields.map((field, index) => (
          <div key={field.id}>
            <p>Address:</p>
            <label htmlFor="addrType">Type:</label>
            <input {...register(`addresses.${index}.addrType`)} id="addrType" placeholder="Addr Type" />
            {errors.addresses?.[index]?.addrType && <p>{errors.addresses[index].addrType.message}</p>}
            <br />
            <input {...register(`addresses.${index}.street1`)} placeholder="Street" size={40} />
            {errors.addresses?.[index]?.street1 && <p>{errors.addresses[index].street1.message}</p>}

            <input {...register(`addresses.${index}.street2`)} placeholder="Addl Street" />
            {errors.addresses?.[index]?.street2 && <p>{errors.addresses[index].street2.message}</p>}
            <br />

            <input {...register(`addresses.${index}.city`)} placeholder="City" />
            {errors.addresses?.[index]?.city && <p>{errors.addresses[index].city.message}</p>}

            <select id="state" {...register(`addresses.${index}.state`)}>
              {States.map((state) => (
                <option key={state} value={state}>
                  {state} {/* Capitalize for display */}
                </option>
              ))}
            </select>
            {errors.addresses?.[index]?.state && <p>{errors.addresses[index].state.message}</p>}

            <input {...register(`addresses.${index}.zip`)} placeholder="Zip" size={5} />
            {errors.addresses?.[index]?.zip && <p>{errors.addresses[index].zip.message}</p>}
            <button type="button" onClick={() => remove(index)}>
              Remove
            </button>
          </div>
        ))}
        <button
          type="button"
          onClick={() =>
            append({
              addrType: "",
              street1: "",
              street2: "",
              city: "",
              state: "",
              zip: "",
            })
          }>
          Add Address
        </button>
        <br />
        <button type="submit">Submit</button>
      </form>
      <p />
      <button onClick={handleRouter}>Back to Menu</button>
      <p />
    </>
  );
}

export default CustomerUpd;

/*
      <Link to="/">Back to Home</Link>
*/
