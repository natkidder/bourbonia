import { useState } from "react";
import React from "react";
import ReactDOM from "react-dom/client";
import createRoot from "react-dom/client";
import "../customer-list/CustomerList.css";
import CustomerSvc from "../customer-list/CustomerSvc";
import PhoneDisplay from "../utils/PhoneDisplay";
import { Link, MemoryRouter, BrowserRouter } from "react-router-dom";
import { useForm, useFieldArray } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { z } from "zod";
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
    </tr>
  );
}

function CustomerAdd(props) {
  const {
    register,
    handleSubmit,
    control,
    formState: { errors },
  } = useForm({
    resolver: zodResolver(CustomerSchema),
  });
  const { fields, append, remove } = useFieldArray({
    control,
    name: "addresses",
  });
  //const onSubmit = (data) => console.log(data);
  const customers = props.customers;

  const onSubmit = async (inputs) => {
    //event.preventDefault();
    console.log(inputs);
    try {
      const response = await fetch("http://localhost:8081/api2/customer", {
        method: "POST",
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
        <CustomerSvc child="CustomerAdd" businessName={props.businessName} outletName={props.outletName} pocFirst={props.pocFirst} pocLast={props.pocLast} />
      </MemoryRouter>
    );
    //window.location.reload();  //TODO added to make link work; try to find a cheaper way
  };
  const handleRouter = () => {
    const container = document.getElementById("root");
    if (container) {
      const root = ReactDOM.createRoot(container);
      root.render(
        <BrowserRouter>
          <ShippingRoute2 />
        </BrowserRouter>
      );
    }
  };
  return (
    <>
      <h1>Add a Customer</h1>
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
      <br />
      <form onSubmit={handleSubmit(onSubmit)}>
        <label htmlFor="businessName">Business:</label>
        <input {...register("businessName")} placeholder="Business" />
        {errors.businessName && <p>{errors.businessName.message}</p>}&nbsp;
        <label htmlFor="outletName">Outlet:</label>
        <input id="outletName" {...register("outletName")} />
        {errors.outletName && <span>{errors.outletName.message}</span>}&nbsp;
        <label htmlFor="pocFirst">POC First Nm:</label>
        <input id="pocFirst" type="pocFirst" {...register("pocFirst")} size={15} />
        &nbsp;
        {errors.pocFirst && <span>{errors.pocFirst.message}</span>}
        <label htmlFor="pocLast">POC Last Nm:</label>
        <input id="pocLast" type="pocLast" {...register("pocLast")} size={15} />
        {errors.pocLast && <span>{errors.pocLast.message}</span>}
        <br />
        <label htmlFor="pocPhone">POC Phone:</label>
        <input id="pocPhone" type="pocPhone" {...register("pocPhone")} />
        {errors.pocPhone && <span>{errors.pocPhone.message}</span>}&nbsp;
        <label htmlFor="pocEmail">POC Email:</label>
        <input id="pocEmail" type="pocEmail" {...register("pocEmail")} size={25} />
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
        <p />
        <button type="submit">Submit</button>
        <p />
      </form>
      <button onClick={handleRouter}>Back to Menu</button>
      <p />
    </>
  );
}

export default CustomerAdd;
/*
  const handleSubmit = async (event) => {
    event.preventDefault();
    console.log(inputs);
    try {
      const response = await fetch("http://localhost:8081/api2/customer", {
        method: "POST",
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
    const root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <MemoryRouter>
        <CustomerSvc child="CustomerAdd" />
      </MemoryRouter>
    );
    //window.location.reload();  //TODO added to make link work; try to find a cheaper way
  };
  */

/*function IndivCustomer(props2) {
  return (
    <tr>
      <td> {props2.id} </td>
      <td> {props2.businessName} </td>
      <td> {props2.outletName} </td>
      <td> {props2.pocFirst} {props2.pocLast} </td>
      <td> <PhoneDisplay phoneNbr={props2.pocPhone} /> </td>
      <td> {props2.pocEmail} </td>
      <td> {props2.addresses.map((a) =>(<div><b>{a.addrType}</b><br/>{a.street1} {a.street2}<br/>{a.city}, {a.state} {a.zip}</div>))}</td>
    </tr>
  );
}
  */
