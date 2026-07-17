const express = require("express");
const router = express.Router();
const authMiddleware = require("../middleware/authMiddleware");

const {
    placeOrder,
    getOrders,
    getOrderById
} = require("../controllers/orderController");

router.post("/", placeOrder);
router.get("/", getOrders);
router.get("/:id", getOrderById);

module.exports = router;