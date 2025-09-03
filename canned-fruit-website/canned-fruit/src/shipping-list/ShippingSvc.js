import React, { useState, useEffect } from "react";
import ShippingList from "./ShippingList.tsx";
import ShippingAdd from "../shipping-add/ShippingAdd";
import ShippingDel from "../shipping-del/ShippingDel";
import ShippingUpd from "../shipping-upd/ShippingUpd";

function ShippingSvc(props) {
  const ChildTag = props.child;
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const shipping = async () => {
      try {
        const response = await fetch("http://localhost:8081/api2/shipping");
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        const result = await response.json();
        console.log(result); ///////
        console.log(data); //////
        setData(result);
        console.log(data); //////
      } catch (err) {
        setError(err);
      } finally {
        setLoading(false);
      }
    };

    shipping();
  }, []);

  if (loading) {
    return <p>Loading...</p>;
  }

  if (error) {
    return <p>Error: {error.message}</p>;
  }

  if (ChildTag === "ShippingList") {
    return <ShippingList shipping={data} />;
  } else if (ChildTag === "ShippingAdd") {
    return <ShippingAdd shipping={data} />;
  } else if (ChildTag === "ShippingDel") {
    return <ShippingDel shipping={data} />;
  } else if (ChildTag === "ShippingUpd") {
    console.log(props.chosenShipping); ////////
    return <ShippingUpd shipping={data} chosenShipping={props.chosenShipping} />;
  }
}

export default ShippingSvc;
