import React from "react";
import ReactDOM from "react-dom/client";
import "./ShippingList.css";
import { BrowserRouter, Link } from "react-router-dom";
import CurrencyDisplay from "../utils/CurrencyDisplay";
import { useNavigate, useLocation } from "react-router-dom";
import ShippingRoute2 from "../shipping-route/ShippingRoute2.tsx";
import ShippingRoute from "../shipping-route/ShippingRoute.js";

function IndivShipping(props2) {
  return (
    <tr>
      <td>{props2.id}</td>
      <td> {props2.type} </td>
      <td>
        {" "}
        <CurrencyDisplay amount={props2.price} />
      </td>
    </tr>
  );
}

function ShippingList(props) {
  const shipping = props.shipping;
  console.log(shipping); ////////
  const navigate = useNavigate();
  const location = useLocation();
  const epochToDt = (epoch) => {
    return new Date(epoch * 1000);
  };
  /* const handleGoBack = () => {
    console.log("window.history.length", window.history.length); ///////
    console.log("location.key", location.key); /////////
    const canGoBack = location.key !== "default";
    const href = canGoBack ? -1 : "/";
    navigate(-1); // Navigates back one step
    //this.goBack();
  };
  const handleNavigation = (href) => {
    console.log("Menu navigation forcing refresh to:", href);
    window.location.href = href;
    //navigate("/Sandbox", { replace: true });
  }; */
  const handleRouter = () => {
    root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <BrowserRouter>
        <ShippingRoute2 />
      </BrowserRouter>
    );
  };
  console.log("ShippingList 10"); //////////
  return (
    <>
      <h1>Shipping Terms</h1>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Type</th>
            <th>Price per Oz</th>
          </tr>
        </thead>
        <tbody>
          {shipping.map((shipping) => (
            <IndivShipping id={shipping.id} type={shipping.type} price={shipping.price} />
          ))}
        </tbody>
      </table>
      <p></p>
      &nbsp;
      {/*<button onClick={handleGoBack}>Back to Main Menu</button>&nbsp;
      <button onClick={(e) => handleNavigation("/")}>handleNavigation</button>*/}
      <button onClick={handleRouter}>Back to Menu</button>
    </>
  );
}

var root = ReactDOM.createRoot(document.getElementById("root"));
//root.render(<AllShipping />);

export default ShippingList;
/*  updOn={shipping.updatedOn}       <td> {props2.updOn} </td>              <th>Last Updated</th>
 */
{
  /* Causes  Failed to execute 'removeChild' on 'Node': The node to be removed is not a child of this node.
<button
  onClick={() =>
    root.render(
      <React.Fragment>
        <ShippingRoute2 />
      </React.Fragment>
    )
  }>
  Return to ShippingRoute2
</button>*/
}
