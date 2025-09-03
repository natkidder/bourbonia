import React from 'react';
import NumberFormat from 'react-number-format';

function CurrencyDisplay({ amount }) {
  const formattedAmount = new Intl.NumberFormat('en-US', {
    style: 'currency',
    currency: 'USD',
  }).format(amount);
  //console.log(amount + "   " +  formattedAmount);
  /* You must use an empty element; span or div fails */
  return (
    <>{formattedAmount}</>
  );
}

export default CurrencyDisplay;