const express = require("express");
const router = express.Router();

const authMiddleware = require("../middleware/authMiddleware");

const {
    addToCart,
    getCart,
    updateCartQuantity
} = require("../controllers/cartController");

router.use(authMiddleware);

router.post("/", addToCart);
router.get("/", getCart);
router.put("/:id", updateCartQuantity);

module.exports = router;