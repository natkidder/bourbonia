import React from "react";
import ReactDOM from "react-dom/client";
import "./CustomerList.css";
import PhoneDisplay from "../utils/PhoneDisplay";
import { Link, BrowserRouter } from "react-router-dom";
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
    </tr>
  );
}

function CustomerList(props) {
  const customers = props.customers;
  //TODO add sorting links in header    https://stackoverflow.com/questions/60088576/how-to-do-default-sorting-in-react-table
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
      <h1>Customers</h1>
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
      <p></p>
      <button onClick={handleRouter}>Back to Menu</button>
      <p />
    </>
  );
}

//const root = ReactDOM.createRoot(document.getElementById('root'));
//root.render(<AllCustomer />);

export default CustomerList;
