import React, { useState, useEffect } from "react";
import CannedFruitList from "./CannedFruitList";
import CannedFruitAdd from "../cannedFruit-add/CannedFruitAdd";
import CannedFruitDel from "../cannedFruit-del/CannedFruitDel";
import CannedFruitUpd from "../cannedFruit-upd/CannedFruitUpd";

function CannedFruitSvc(props) {
  const ChildTag = props.child;
  var [data, setData] = useState({});
  const [mediumsData, setMediumsData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [mediumsLoading, setMediumsLoading] = useState(true);
  const [MediumsError, setMediumsError] = useState(null);

  useEffect(() => {
    var result = "";
    const medium = async () => {
      try {
        const response = await fetch("http://localhost:8081/api2/medium");
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        const result = await response.json();
        //console.log(result); ///////
        setMediumsData(result);
        //console.log(mediumsData); ///////
      } catch (err) {
        setMediumsError(err);
      } finally {
        await setMediumsLoading(false);
      }
    };
    medium();
  }, []);

  useEffect(() => {
    const cannedFruit = async () => {
      try {
        const response = await fetch("http://localhost:8081/api2/cannedFruit");
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        const result = await response.json();
        console.log(result); ///////
        setData(result);
      } catch (err) {
        setError(err);
      } finally {
        await setLoading(false);
      }
    };
    cannedFruit();
  }, []);
  //console.log(mediumsData); ///////

  if (loading) {
    return <p>Loading...</p>;
  }

  if (error) {
    return <p>Error: {error.message}</p>;
  }
  console.log("before entering options", data); //////////
  if (ChildTag == "CannedFruitList") {
    return <CannedFruitList cannedFruit={data} />;
  } else if (ChildTag == "CannedFruitAdd") {
    //console.log(mediumsData); ///////
    return <CannedFruitAdd cannedFruit={data} mediums={mediumsData} />;
  } else if (ChildTag == "CannedFruitDel") {
    return <CannedFruitDel cannedFruit={data} />;
  } else if (ChildTag == "CannedFruitUpd") {
    return <CannedFruitUpd cannedFruit={data} mediums={mediumsData} chosenCannedFruit={props.chosenCannedFruit} />;
  }
}

async function GetMediums() {
  try {
    const response = await fetch("http://localhost:8081/api2/medium");

    if (response.ok) {
      const resp = await response.json();
      console.log("Success:", resp);
      return resp;
    } else {
      console.error("Error:", response.status);
    }
  } catch (error) {
    console.error("Error:", error);
  }
  return null;
  //const root = ReactDOM.createRoot(document.getElementById('root'));
  // root.render(<ShippingSvc child="ShippingDel" />);
}

export default CannedFruitSvc;
