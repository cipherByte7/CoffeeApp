const Order = require("../models/orderModel");
const Cart = require("../models/cartModel");

// POST /api/orders
const placeOrder = async (req, res) => {
  try {

    console.log("========== PLACE ORDER ==========");
    console.log("BODY:", req.body);

    const { paymentMode } = req.body;

    const cartItems = await Cart.find({
      user: req.userId,
    }).populate("product");

    if (cartItems.length === 0) {
      return res.status(400).json({
        message: "Cart is empty",
      });
    }

    const items = cartItems.map((cartItem) => ({
      product: cartItem.product._id,
      quantity: cartItem.quantity,
      price: cartItem.product.price,
    }));

    const totalAmount = items.reduce(
      (sum, item) => sum + item.price * item.quantity,
      0,
    );

    const order = await Order.create({
      user: req.userId,
      items,
      totalAmount,
      paymentMode,
    });

    // Clear the cart after the order is placed
    await Cart.deleteMany({
      user: req.userId,
    });
    const populatedOrder = await Order.findById(order._id).populate(
      "items.product",
    );

    res.status(201).json(populatedOrder);
  } catch (error) {
    res.status(500).json({
      message: error.message,
    });
  }
};

// GET /api/orders
const getOrders = async (req, res) => {
  try {
    const orders = await Order.find({
      user: req.userId,
    })
      .sort({ createdAt: -1 })
      .populate("items.product");

    res.json(orders);
  } catch (error) {
    res.status(500).json({
      message: error.message,
    });
  }
};

// GET /api/orders/:id
const getOrderById = async (req, res) => {
  try {
    const order = await Order.findOne({
        _id: req.params.id,
        user: req.userId,
    }).populate("items.product");

    if (!order) {
      return res.status(404).json({
        message: "Order not found",
      });
    }

    res.json(order);
  } catch (error) {
    res.status(500).json({
      message: error.message,
    });
  }
};

module.exports = {
  placeOrder,
  getOrders,
  getOrderById,
};
