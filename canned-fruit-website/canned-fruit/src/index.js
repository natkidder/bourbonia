import React from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter } from "react-router-dom";
import "./index.css";
//import App from './App';
//import AllShipping from './shipping-list/ShippingList';
//import ShippingSvc from './shipping-list/ShippingSvc';
//import ShippingAdd from './shipping-add/ShippingAdd';
//import ShippingDel from './shipping-del/ShippingDel';
import ShippingRoute from "./shipping-route/ShippingRoute";
//import CannedFruitSvc from './cannedFruit-list/CannedFruitSvc.js'
import reportWebVitals from "./reportWebVitals";
import Sandbox from "./sandbox/Sandbox.js";
import EntryPage from "./shipping-route/EntryPage.tsx";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <EntryPage />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
