import ReactDOM from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import ShippingSvc from "../shipping-list/ShippingSvc";
import CannedFruitSvc from "../cannedFruit-list/CannedFruitSvc";
import CustomerSvc from "../customer-list/CustomerSvc";
import ShippingLink from "./ShippingLink";
import CustomerOrderSvc from "../customerOrder-list/CustomerOrderSvc.tsx";
import Sandbox from "../sandbox/Sandbox";
import EntryPage from "./EntryPage.tsx";

function ShippingRoute() {
  return (
    <BrowserRouter>
      <Routes>
        {/*<Route exact path="/" element={<ShippingLink />} />*/}
        <Route path="/ShippingList" element={<ShippingSvc child="ShippingList" />} />
        <Route path="/ShippingAdd" element={<ShippingSvc child="ShippingAdd" />} />
        <Route path="/ShippingUpd" element={<ShippingSvc child="ShippingUpd" />} />
        <Route path="/ShippingDel" element={<ShippingSvc child="ShippingDel" />} />
        <Route path="/CannedFruitList" element={<CannedFruitSvc child="CannedFruitList" />} />
        <Route path="/CannedFruitAdd" element={<CannedFruitSvc child="CannedFruitAdd" />} />
        <Route path="/CannedFruitUpd" element={<CannedFruitSvc child="CannedFruitUpd" />} />
        <Route path="/CannedFruitDel" element={<CannedFruitSvc child="CannedFruitDel" />} />
        <Route path="/CustomerList" element={<CustomerSvc child="CustomerList" businessName="" outletName="" pocFirst="" pocLast="" />} />
        <Route path="/CustomerAdd" element={<CustomerSvc child="CustomerAdd" businessName="" outletName="" pocFirst="" pocLast="" />} />
        <Route path="/CustomerUpd" element={<CustomerSvc child="CustomerUpd" businessName="" outletName="" pocFirst="" pocLast="" />} />
        <Route path="/CustomerDel" element={<CustomerSvc child="CustomerDel" businessName="" outletName="" pocFirst="" pocLast="" />} />
        <Route path="/CustomerOrderAdd" element={<CustomerOrderSvc child="CustomerOrderAdd" />} />
        <Route path="/" element={<EntryPage />} />
        <Route path="/Sandbox" element={<Sandbox child="HomePage" businessName="" outletName="" pocFirst="" pocLast="" />} />
      </Routes>
    </BrowserRouter>
  );
}
export default ShippingRoute;
