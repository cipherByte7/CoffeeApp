const Cart = require("../models/cartModel");
const USER_ID = "6a5930c0794e8cbd295cccf8";

// POST /api/cart
const addToCart = async (req, res) => {
  try {
    const { productId } = req.body;

    console.log("========== ADD TO CART ==========");
    console.log("USER ID:", req.userId);
    console.log("PRODUCT ID:", productId);
    console.log("REQUEST BODY:", req.body);

    let cartItem = await Cart.findOne({
     user: USER_ID,
      product: productId,
    });

    console.log("EXISTING CART ITEM:", cartItem);

    if (cartItem) {
      cartItem.quantity += 1;
      await cartItem.save();
    } else {
      cartItem = await Cart.create({
       user: USER_ID,
        product: productId,
        quantity: 1,
      });

      console.log("CREATED CART ITEM:", cartItem);
    }

    const populatedCartItem = await Cart.findById(cartItem._id).populate(
      "product"
    );

    console.log("RETURNING:", populatedCartItem);

    res.status(200).json(populatedCartItem);
  } catch (error) {
    console.error("========== ADD TO CART ERROR ==========");
    console.error(error);

    res.status(500).json({
      message: error.message,
    });
  }
};

// GET /api/cart
const getCart = async (req, res) => {
  try {
    console.log("========== GET CART ==========");
    console.log("USER ID:", req.userId);

    const cartItems = await Cart.find({
      user: USER_ID,
    }).populate("product");

    console.log("CART ITEMS:", cartItems);

    res.json(cartItems);
  } catch (error) {
    console.error("========== GET CART ERROR ==========");
    console.error(error);

    res.status(500).json({
      message: error.message,
    });
  }
};

// PUT /api/cart/:id
const updateCartQuantity = async (req, res) => {
  try {
    const { id } = req.params;
    const { quantity } = req.body;

    const cartItem = await Cart.findOne({
      _id: id,
     user: USER_ID,
    });

    if (!cartItem) {
      return res.status(404).json({
        message: "Cart item not found",
      });
    }

    if (quantity <= 0) {
      await Cart.findByIdAndDelete(id);

      return res.json({
        message: "Item removed from cart",
      });
    }

    cartItem.quantity = quantity;

    await cartItem.save();

    const populatedItem = await Cart.findById(cartItem._id).populate("product");

    res.json(populatedItem);
  } catch (error) {
    console.error("========== UPDATE CART ERROR ==========");
    console.error(error);

    res.status(500).json({
      message: error.message,
    });
  }
};

module.exports = {
  addToCart,
  getCart,
  updateCartQuantity,
};