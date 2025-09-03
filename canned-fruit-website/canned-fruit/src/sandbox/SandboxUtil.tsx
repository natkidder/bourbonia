import { zodResolver } from "@hookform/resolvers/zod";
import { z } from "zod";

const Cnts = ["0", "6", "8", "12", "18", "24", "30", "36", "48"] as const;
const States = ["", "FL", "GA", "NC", "SC", "VA"] as const; // Use 'as const'
const orderStatuses = ["New", "In Process", "Cancelled", "Completed"] as const;
const stateTaxRates = {
  FL: 0.0702,
  GA: 0.04,
  NC: 0.0475,
  SC: 0.06,
  VA: 0.053,
};

type CustomerOrderItem = {
  cannedFruit: {
    id: number;
    fruit: string;
    volume: number;
    container: string;
    pricePer: number;
    unitType: string;
    medium: {
      id: number;
      mediumName: string;
    };
  };
  cnt: string; // Default value, can be updated later
};

const customerOrderItems = (customerOrderItems: any[]): CustomerOrderItem[] => {
  let json: CustomerOrderItem[] = [];
  customerOrderItems.forEach((item) => {
    //console.log("item", item); //////
    json.push({
      cannedFruit: {
        id: item.id,
        fruit: item.fruit,
        volume: item.volume,
        container: item.container,
        pricePer: item.pricePer,
        unitType: item.unitType,
        medium: {
          id: item.medium.id,
          mediumName: item.medium.mediumName,
        },
      },
      cnt: "0", // Default value, can be updated later",
    });
  });
  return json;
};
const updOCF = (newItemsOCF, ordCannedFruits02, index, name, value) => {
  //console.log("updOCF ordCannedFruits02", ordCannedFruits02); //////
  newItemsOCF[index][name] = value;
  for (let i = 0; i < ordCannedFruits02.length; i++) {
    let item = ordCannedFruits02[i];
    if (item.cannedFruit && item.cannedFruit.id !== newItemsOCF[index].cannedFruit.id) {
      //console.log("updOCF setting cnt for index", i, "with", item.cnt); //////
      newItemsOCF[i]["cnt"] = item.cnt;
      //console.log("updOCF newItemsOCF index cnt", newItemsOCF[index].cnt); //////
    }
  }
  console.log("updOCF newItemsOCF", newItemsOCF); //////
  return newItemsOCF;
};
const removeExtraneousCannedFruit = (items) => {
  items.forEach((item) => {
    delete item.cannedFruit.fruit;
    delete item.cannedFruit.volume;
    delete item.cannedFruit.container;
    delete item.cannedFruit.pricePer;
    delete item.cannedFruit.unitType;
    if (item.cannedFruit.medium !== undefined) {
      delete item.cannedFruit.medium.id;
      delete item.cannedFruit.medium.mediumName;
      delete item.cannedFruit.medium;
    }
  });
  //console.log("removeExtraneousCannedFruit", items); //////
  return items;
};

const removeExtraneousSTAF = (item) => {
  //console.log("in removeExtraneousSTAF", item); ///////
  if (item && item.addrType !== undefined) {
    delete item.addrType;
  }
  if (item && item.street1 !== undefined) {
    delete item.street1;
  }
  if (item && item.street2 !== undefined) {
    delete item.street2;
  }
  if (item && item.city !== undefined) {
    delete item.city;
  }
  if (item && item.state !== undefined) {
    delete item.state;
  }
  if (item && item.zip !== undefined) {
    delete item.zip;
  }
  if (item && item.updRadios !== undefined) {
    //console.log("deleting updRadios key"); ///////
    delete item.updRadios;
  }
  //console.log("after removeExtraneousSTAF", item); ///////
};

const removeExtraneousShipping = (item) => {
  //console.log("in removeExtraneousSTAF", item); ///////
  if (item && item.type !== undefined) {
    delete item.type;
  }
  if (item && item.price !== undefined) {
    delete item.price;
  }
  // leaving out createdOn and updatedOn as they don't apprear in the form
  if (item && item.updRadios !== undefined) {
    delete item.updRadios;
  }
  //console.log("after removeExtraneousSTAF", item); ///////
};

const calcTotalCosts = (ordCannedFruits, newOCF, shippingPrice, shipToState) => {
  console.log("in calcTotalCosts, ordCannedFruits:", ordCannedFruits); ///////
  console.log("in calcTotalCosts, newOCF:", newOCF); ///////
  console.log("in calcTotalCosts, shippingPrice:", shippingPrice); ///////
  //console.log("in calcTotalCosts, shipToState:", shipToState); ///////
  //let cntPriceVolume = [];
  if (
    !ordCannedFruits ||
    ordCannedFruits.length === 0 ||
    !newOCF ||
    newOCF.length === 0 ||
    shipToState === undefined ||
    shipToState === null ||
    shipToState === "" ||
    shippingPrice === undefined ||
    shippingPrice === null ||
    shippingPrice < 0
  ) {
    console.log("in calcTotalCosts, failed nullcheck returning 0.0"); ///////
    return 0.0;
  }
  let totalCost = 0.0;
  let totalVolume = 0;
  for (let i = 0; i < newOCF.length; i++) {
    let order = newOCF[i];
    console.log("order:", i, order.cnt); ///////
    let offering = ordCannedFruits.find((o) => o.cannedFruit.id === order.cannedFruit.id);
    if (offering) {
      let offeringCost = offering.cannedFruit.pricePer * offering.cannedFruit.volume * order.cnt;
      totalCost = totalCost + offeringCost;
      console.log("offeringCost:", offeringCost.toFixed(2), " totalCost:", totalCost.toFixed(2)); ///////
      //totalCost = +(offering.cannedFruit.pricePer * offering.cannedFruit.volume * order.cnt);
      totalVolume = totalVolume + offering.cannedFruit.volume;
      console.log("totalVolume:", totalVolume); ///////
    }
  }
  //console.log("shippingCost:", shippingPrice * totalVolume); ///////
  if (stateTaxRates[shipToState]) {
    //console.log("applying tax rate for", shipToState, ":", stateTaxRates[shipToState], totalCost * (1 + stateTaxRates[shipToState])); ///////
    totalCost = +(totalCost * (1 + stateTaxRates[shipToState])).toFixed(2);
  }
  totalCost = totalCost + shippingPrice * totalVolume;
  //console.log("in createCntPriceVolume, cntPriceVolume:", cntPriceVolume); ///////
  return totalCost;
};

//const reconstructOrder = (baseOrder, shipToAddress, shipping) => {
const reconstructOrder = (baseOrder) => {
  let order = JSON.parse(JSON.stringify(baseOrder)); // Deep copy TODO use a library like lodash or work directly with baseOrder
  //console.log("reconstructOrder baseOrder", baseOrder); //////
  //order.shipToAddress = shipToAddress.shipToAddress;
  //order.shipping = shipping.shipping;
  //console.log("order", order); //////
  //console.log("shipToAddress_id", order.shipToAddress_id); //////
  let customer = { customer: { id: 0 } };
  customer.customer.id = order.customer_id;
  delete order.customer_id;
  order.customer = customer.customer;
  if (order && order.cnt !== undefined) {
    delete order.cnt; // remove cnt if it exists
  }
  if (order && order.shipToAddress_id !== undefined) {
    let shipToAddressObj = { shipToAddress: { id: 0 } };
    shipToAddressObj.shipToAddress.id = order.shipToAddress_id;
    order.shipToAddress = shipToAddressObj.shipToAddress;
    delete order.shipToAddress_id; // remove id if it exists
  }
  if (order && order.shipping_id !== undefined) {
    //console.log("deleting shipping_id key"); ///////
    let shipping = { shipping: { id: 0 } };
    shipping.shipping.id = order.shipping_id;
    order.shipping = shipping.shipping;
    delete order.shipping_id; // remove id if it exists
  }
  if (order && order.cardNbr !== undefined) {
    order.cardNbr = order.cardNbr.toString(); // convert to string
    order.cardNbr = order.cardNbr.replace(/\s+/g, "").replace(/-/g, ""); // remove spaces and dashes
  }
  if (order && order.expirationDt !== undefined) {
    let components = order.expirationDt.split("/");
    const currCentury = "20";
    if (components.length === 2) {
      let month = components[0].trim();
      let year = components[1].trim();
      if (year.length === 2) {
        year = currCentury + year; // pad two digit year with leading 20
      }
      const mthNbr = Number(month); // the months run from Feb of this year to Jan of next year
      //console.log("mthNbr", mthNbr); ///////
      const yrNbr = Number(year); // + (mthNbr === 12 ? 1 : 0); // if month is Jan, increment year
      let expDt = new Date(yrNbr, mthNbr, 1).toLocaleDateString("en-CA"); // last day of month
      //console.log("expDt", expDt); ///////
      order.expirationDt = expDt;
    }
    //console.log("order after adding customer", order); //////
    return order;
  }
};

const enableSubmit = (shipToAddress, shipping, nameOnCard, cardNbr, expirationDt, cvv) => {
  //console.log("enableSubmit shipToAddress", shipToAddress); ///////
  //let shipToAddress03 = JSON.parse(JSON.stringify(shipToAddress));
  //let shipping03 = JSON.parse(JSON.stringify(shipping));
  cardNbr.replace(/\s+/g, "").replace(/-/g, ""); // remove spaces and dashes
  const cardNbrRegex = new RegExp("^[0-9]{13,19}$"); // Visa, MasterCard, AmEx, Discover
  const expirationDtRegex = new RegExp("^(0[1-9]|1[0-2])/(\\d{2})$"); // MM/YY or MM/YYYY
  const cvvRegex = new RegExp("^[0-9]{3,4}$"); // 3 or 4 digits
  let submitFormEnabled = false;
  //console.log("cardNbrRegex.test(cardNbr)", cardNbrRegex.test(cardNbr)); ///////
  //console.log("expirationDtRegex.test(expirationDt)", expirationDtRegex.test(expirationDt)); ///////
  //console.log("cvvRegex.test(cvv)", cvvRegex.test(cvv)); //////
  //console.log("shipToAddress id", shipToAddress.shipToAddress ? shipToAddress.shipToAddress.id : "STA.STA not there"); ///////
  //console.log("shipping id", shipping.shipping ? shipping.shipping.id : "shipping.shipping not there"); ///////
  if (
    shipToAddress &&
    shipToAddress.shipToAddress &&
    shipToAddress.shipToAddress.id > 0 &&
    shipping &&
    shipping.shipping &&
    shipping.shipping.id > 0 &&
    nameOnCard !== "" &&
    cardNbrRegex.test(cardNbr) &&
    expirationDtRegex.test(expirationDt) &&
    cvvRegex.test(cvv)
  ) {
    submitFormEnabled = true;
  }
  //console.log("cvv", cvv); ///////
  //console.log("submitFormEnabled", submitFormEnabled); ///////
  return submitFormEnabled;
};

export {
  Cnts,
  States,
  orderStatuses,
  customerOrderItems,
  updOCF,
  removeExtraneousCannedFruit,
  removeExtraneousSTAF,
  removeExtraneousShipping,
  reconstructOrder,
  enableSubmit,
  calcTotalCosts,
};
