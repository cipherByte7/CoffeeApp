const express = require("express");
const authMiddleware = require("../middleware/authMiddleware");
const router = express.Router();

const {
  toggleFavorite,
  getFavorites,
} = require("../controllers/favoriteController");

router.use(authMiddleware);

// Toggle Favorite
router.post("/toggle", toggleFavorite);

// Get All Favorites
router.get("/", getFavorites);



module.exports = router;