const express = require("express");

const router = express.Router();

const {
  toggleFavorite,
  getFavorites,
} = require("../controllers/favoriteController");

// Toggle Favorite
router.post("/toggle", toggleFavorite);

// Get All Favorites
router.get("/", getFavorites);

module.exports = router;