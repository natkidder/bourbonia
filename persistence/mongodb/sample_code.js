db.theatres.aggregate([
  { $match : { "location.address.state" : "TX" } },
  { $limit: 7 },
  { $project: {
    "location.address.street": 1,
    "location.address.city": 1,
    "location.address.zip": 1
  }}
])
db.posts.aggregate([
  {
    $addFields: {
      avgLikes: { $avg: "$likes" }
    }
  },
  {
    $project: {
      "title": 1,
      "avgLikes": 1
    }
  },
  {
    $limit: 5
  }
])

db.theatres.aggregate([
  {
    $match: { "location.address.state": "TX" }
  },
  {
    $count: "TexasCount"
  }
])

db.theatres.bulkWrite([
  { "updateMany": {
    "filter": { "location.address.state": { "$eq": "CA" } },
    "update": { "$set": { "popcorn": "ranch" } }
  }},
  { "updateMany": {
    "filter": { "location.address.state": { "$eq": "TX" } },
    "update": { "$set": { "popcorn": "caramel" } }
  }}
])

db.popcorn.insertOne({
	type: "buttered",
	calories: 1090
})

db.popcorn.insertMany([
	{
		type: "ranch",
		calories: 870
	},
	{
		type: "caramel",
		calories: 1320
	}
])

db.comments.aggregate([
  {
    $lookup: {
      from: "theatres",
      localField: "popcorn",
      foreignField: "type",
      as: "popcor_dtls",
    },
  },
  {
    $limit: 1
  }
])
