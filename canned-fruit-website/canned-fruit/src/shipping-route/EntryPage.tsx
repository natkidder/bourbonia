import { useState } from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter, Link, MemoryRouter } from "react-router-dom";
import CustomerOrderSvc from "../customerOrder-list/CustomerOrderSvc.tsx";
import ShippingRoute from "../shipping-route/ShippingRoute";
import { email } from "zod";
import React from "react";
import ShippingLink from "./ShippingLink.js";
import ShippingRoute2 from "./ShippingRoute2.tsx";
import CustomerSelfAdd from "../customer-add/CustomerSelfAdd.tsx";

// Sends a user to another form based on her/his email address entered
function EntryPage() {
  const [inputs, setInputs] = useState({ emailAddress: "" });
  const adminEmail = "admin@cannedFruit.com";
  var [customers, setCustomers] = useState([{}]);
  var [customer, setCustomer] = useState({});
  var [count, setCount] = useState(0); //// for testing useState
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [emailExistMsg, setEmailExistMsg] = useState("");
  const [hideEEM, setHideEEM] = useState(true);
  var url = "";

  const incrementCount = () => {
    ///////
    setCount((prevCount) => prevCount + 1); ///////
  }; ///////

  const handleChange = (event) => {
    const name = event.target.name;
    const value = event.target.value;
    setInputs((values) => ({ ...values, [name]: value }));
  };

  const handleCustomerSelfAdd = (event) => {
    event.preventDefault();
    root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <MemoryRouter>
        <CustomerSelfAdd />
      </MemoryRouter>
    );
  };
  const handleSubmit = async (event) => {
    event.preventDefault();
    const pocEmail = inputs.emailAddress;
    //console.log(inputs);
    //const root = ReactDOM.createRoot(document.getElementById("root"));
    if (pocEmail === adminEmail) {
      console.log("pocEmail is admin"); /////////
      root = ReactDOM.createRoot(document.getElementById("root"));
      root.render(
        <MemoryRouter>
          <ShippingRoute2 />
        </MemoryRouter>
      );
    } else {
      url = "http://localhost:8081/api2/customer/pocEmail/" + pocEmail;
      try {
        // await is required for the web svc call to work, but cannot be called inside a loop
        // we cannot make it a function, as functions must return HTML elements
        const response = await fetch(url, {
          method: "GET",
        });
        console.log(response.toString()); /////////
        if (response.ok) {
          let data = await response.json();
          customers = [...customers.slice(1), data]; // customers must be an array
          console.log("customers after slicing", customers); /////////
          if (customers.length > 0) {
            customer = customers.at(0) ?? {}; // setCustomer, even in a top-level function, did not work
            console.log("customers.at(0)", customer); //////////
            incrementCount(); ///////
            root = ReactDOM.createRoot(document.getElementById("root"));
            root.render(
              <BrowserRouter>
                <CustomerOrderSvc customer={customer} />
              </BrowserRouter>
            );
          } else {
            setEmailExistMsg(pocEmail + " is not registered");
            setHideEEM(false);
          }
        } else {
          setEmailExistMsg(pocEmail + " is not registered");
          setHideEEM(false);
          //console.error("Error:", response.status);
        }
      } catch (error) {
        console.error("Error:", error);
      } finally {
        await setLoading(false);
      }
    }
  };

  return (
    <>
      <h2>Welcome to Canned Fruits</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Enter your email address:&nbsp;
          <input type="email" name="emailAddress" value={inputs.emailAddress || ""} onChange={handleChange} />
        </label>
        <br />
        <p hidden={hideEEM}>{emailExistMsg}</p>
        <input type="submit" />
        <p />
        <button type="button" onClick={(e) => handleCustomerSelfAdd(e)}>
          {" "}
          Register
        </button>
        &nbsp;
        <p />
      </form>
    </>
  );
}

var root = ReactDOM.createRoot(document.getElementById("root") as HTMLElement);
//root.render(<EntryPage />);

export default EntryPage;
