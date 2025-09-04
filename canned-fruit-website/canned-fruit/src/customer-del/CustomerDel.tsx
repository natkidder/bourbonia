import React from "react";
import { useState, useEffect } from "react";
import ReactDOM from "react-dom/client";
import createRoot from "react-dom/client";
import "../customer-list/CustomerList.css";
import PhoneDisplay from "../utils/PhoneDisplay";
import { Link, MemoryRouter, BrowserRouter } from "react-router-dom";
import CustomerSvc from "../customer-list/CustomerSvc";
import ShippingRoute2 from "../shipping-route/ShippingRoute2.tsx";

function IndivCustomer(props2) {
  return (
    <tr>
      <td> {props2.id} </td>
      <td> {props2.businessName} </td>
      <td> {props2.outletName}</td>
      <td>
        {" "}
        {props2.pocFirst} {props2.pocLast}
      </td>
      <td>
        {" "}
        <PhoneDisplay phoneNbr={props2.pocPhone} />
      </td>
      <td> {props2.pocEmail}</td>
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
        <input type="checkbox" name={`isDeleting_${props2.id}`} value={props2.id} />{" "}
      </td>
    </tr>
  );
}

function CustomerDel(props) {
  const customers = props.customers;
  //TODO add sorting links in header    https://stackoverflow.com/questions/60088576/how-to-do-default-sorting-in-react-table
  const [inputs, setInputs] = useState({});
  const handleSubmit = async (event) => {
    event.preventDefault();
    const formData = new FormData(event.target);
    let values = JSON.stringify(Object.fromEntries(formData.entries()));
    let json = JSON.parse(values);
    console.log(json); ///////
    var jsonOptions = Object.keys(json).map(function (key) {
      let deletingCustomerId = json[key];
      console.log(deletingCustomerId); ///////
      //return <CustomerDelSvc id={deletingCustomerId} />
      CustomerDelSvc2(deletingCustomerId);
    });
    const root = ReactDOM.createRoot(document.getElementById("root") as Element);
    root.render(
      <MemoryRouter>
        <CustomerSvc child="CustomerDel" businessName={props.businessName} outletName={props.outletName} pocFirst={props.pocFirst} pocLast={props.pocLast} />
      </MemoryRouter>
    );
    //window.location.reload(); //TODO added to make link work; try to find a cheaper way
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
      <h1>Remove Customers</h1>
      <h2>Select Customers to Remove</h2>
      <form onSubmit={handleSubmit}>
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
              <th>Del?</th>
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
        <input type="submit" value="Confirm Delete" />
      </form>
      <p></p>
      <button onClick={handleRouter}>Back to Menu</button>
    </>
  );
}

async function CustomerDelSvc2(id) {
  try {
    const response = await fetch("http://localhost:8081/api2/customer/" + id, {
      method: "DELETE",
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
  //const root = ReactDOM.createRoot(document.getElementById('root'));
  // root.render(<CustomerSvc child="CustomerDel" />);
}

export default CustomerDel;

/*
      <Link to="/">Back to Home</Link>
*/
