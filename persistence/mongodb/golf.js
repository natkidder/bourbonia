db.theatres.aggregate([ 
  { 
    $sort: { "location.address.state": -1 } 
  },
  {
    $project: {
      "location.address.street1": 1,
      "location.address.city": 1,
	  "location.address.state": 1,
	  "location.address.state": 1
    }
  },
  {
    $limit: 5
  }
])