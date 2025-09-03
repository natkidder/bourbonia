import React from "react";
import { Link } from "react-router-dom";
import ShippingRoute from "./ShippingRoute";

function ShippingLink() {
  return (
    <div>
      <h1>Admin Home Page</h1>
      <Link to="/ShippingList">List Shipping Terms</Link>
      <br />
      <Link to="/ShippingAdd">Add a Shipping Term</Link>
      <br />
      <Link to="/ShippingUpd">Update a Shipping Term</Link>
      <br />
      <Link to="/ShippingDel">Remove a Shipping Term</Link>
      <br />
      <br />
      <Link to="/CannedFruitList">List Canned Fruit</Link>
      <br />
      <Link to="/CannedFruitAdd">Add Canned Fruit</Link>
      <br />
      <Link to="/CannedFruitUpd">Update Canned Fruit</Link>
      <br />
      <Link to="/CannedFruitDel">Delete Canned Fruit</Link>
      <br />
      <br />
      <Link to="/CustomerList">List Customers</Link>
      <br />
      <Link to="/CustomerAdd">Add Customers</Link>
      <br />
      <Link to="/CustomerUpd">Update Customers</Link>
      <br />
      <Link to="/CustomerDel">Delete Customers</Link>
      <br />
      <br />
      <Link to="/">Logout</Link>
      {/*<br />
      <br />
      <Link to="/Sandbox">Sandbox</Link> */}
    </div>
  );
}

export default ShippingLink;
