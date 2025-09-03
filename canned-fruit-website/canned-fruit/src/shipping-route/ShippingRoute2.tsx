import { useState } from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter, Link, MemoryRouter } from "react-router-dom";
import CustomerOrderSvc from "../customerOrder-list/CustomerOrderSvc.tsx";
import ShippingRoute from "./ShippingRoute.js";
import { email } from "zod";
import ShippingSvc from "../shipping-list/ShippingSvc.js";
import CannedFruitSvc from "../cannedFruit-list/CannedFruitSvc.js";
import CustomerSvc from "../customer-list/CustomerSvc.js";
import EntryPage from "./EntryPage.tsx";

// Sends a user to another form based on her/his email address entered
function ShippingRoute2() {
  //window.location.href = "http://localhost:3000/AdminMenu";
  const handleListShipping = (event) => {
    event.preventDefault();
    root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <BrowserRouter>
        <ShippingSvc child="ShippingList" />
      </BrowserRouter>
    );
  };
  const handleAddShipping = (event) => {
    event.preventDefault();
    root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <MemoryRouter>
        <ShippingSvc child="ShippingAdd" />
      </MemoryRouter>
    );
  };
  const handleUpdShipping = (event) => {
    event.preventDefault();
    root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <MemoryRouter>
        <ShippingSvc child="ShippingUpd" />
      </MemoryRouter>
    );
  };
  const handleDelShipping = (event) => {
    event.preventDefault();
    root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <MemoryRouter>
        <ShippingSvc child="ShippingDel" />
      </MemoryRouter>
    );
  };
  const handleListOfferings = (event) => {
    event.preventDefault();
    root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <MemoryRouter>
        <CannedFruitSvc child="CannedFruitList" />
      </MemoryRouter>
    );
  };
  const handleAddOfferings = (event) => {
    event.preventDefault();
    root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <MemoryRouter>
        <CannedFruitSvc child="CannedFruitAdd" />
      </MemoryRouter>
    );
  };
  const handleUpdOfferings = (event) => {
    event.preventDefault();
    root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <MemoryRouter>
        <CannedFruitSvc child="CannedFruitUpd" />
      </MemoryRouter>
    );
  };
  const handleDelOfferings = (event) => {
    event.preventDefault();
    root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <MemoryRouter>
        <CannedFruitSvc child="CannedFruitDel" />
      </MemoryRouter>
    );
  };
  const handleListCustomers = (event) => {
    event.preventDefault();
    root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <MemoryRouter>
        <CustomerSvc child="CustomerList" businessName="" outletName="" pocFirst="" pocLast="" />
      </MemoryRouter>
    );
  };
  const handleAddCustomers = (event) => {
    event.preventDefault();
    root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <MemoryRouter>
        <CustomerSvc child="CustomerAdd" businessName="" outletName="" pocFirst="" pocLast="" />
      </MemoryRouter>
    );
  };
  const handleUpdCustomers = (event) => {
    event.preventDefault();
    root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <MemoryRouter>
        <CustomerSvc child="CustomerUpd" businessName="" outletName="" pocFirst="" pocLast="" />
      </MemoryRouter>
    );
  };
  const handleDelCustomers = (event) => {
    event.preventDefault();
    root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <MemoryRouter>
        <CustomerSvc child="CustomerDel" businessName="" outletName="" pocFirst="" pocLast="" />
      </MemoryRouter>
    );
  };
  const handleLogout = (event) => {
    event.preventDefault();
    root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <MemoryRouter>
        <EntryPage />
      </MemoryRouter>
    );
  };
  const handleNavigation = (href: string) => {
    console.log("🔄 Menu navigation forcing refresh to:", href);
    window.location.href = href;
  };

  return (
    <>
      <h3>Shipping Terms</h3>
      <button type="button" onClick={(e) => handleListShipping(e)}>
        {" "}
        List Shipping Terms
      </button>
      &nbsp;
      <button type="button" onClick={(e) => handleAddShipping(e)}>
        {" "}
        Add Shipping Terms
      </button>
      &nbsp;
      <button type="button" onClick={(e) => handleUpdShipping(e)}>
        {" "}
        Update Shipping Terms
      </button>
      &nbsp;
      <button type="button" onClick={(e) => handleDelShipping(e)}>
        {" "}
        Remove Shipping Terms
      </button>
      &nbsp;
      <p />
      <h3>Canned Fruit Offerings</h3>
      <button type="button" onClick={(e) => handleListOfferings(e)}>
        {" "}
        List Offerings
      </button>
      &nbsp;
      <button type="button" onClick={(e) => handleAddOfferings(e)}>
        {" "}
        Add Offerings
      </button>
      &nbsp;
      <button type="button" onClick={(e) => handleUpdOfferings(e)}>
        {" "}
        Update Offerings
      </button>
      &nbsp;
      <button type="button" onClick={(e) => handleDelOfferings(e)}>
        {" "}
        Remove Offerings
      </button>
      &nbsp;
      <p />
      <h3>Customers</h3>
      <button type="button" onClick={(e) => handleListCustomers(e)}>
        {" "}
        List Customers
      </button>
      &nbsp;
      <button type="button" onClick={(e) => handleAddCustomers(e)}>
        {" "}
        Add Customers
      </button>
      &nbsp;
      <button type="button" onClick={(e) => handleUpdCustomers(e)}>
        {" "}
        Update Customers
      </button>
      &nbsp;
      <button type="button" onClick={(e) => handleDelCustomers(e)}>
        {" "}
        Remove Customers
      </button>
      &nbsp;
      <p />
      <button type="button" onClick={(e) => handleNavigation("http://localhost:3000/entry")}>
        {" "}
        Logout
      </button>
      &nbsp;
    </>
  );
}

var root = ReactDOM.createRoot(document.getElementById("root"));
//root.render(<ShippingRoute2 />);

export default ShippingRoute2;

{
  /* handleNavigation("/ShippingList")}>*/
}
