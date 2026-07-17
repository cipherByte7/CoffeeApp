const express = require("express");
const router = express.Router();

const { addToCart, getCart, updateCartQuantity } = require("../controllers/cartController");

router.post("/", addToCart);
router.get("/", getCart);
router.put("/:id", updateCartQuantity);

module.exports = router;