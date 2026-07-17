const Favorite = require("../models/favoriteModel");

// POST /api/favorites/toggle
const toggleFavorite = async (req, res) => {
  try {
    const { productId } = req.body;

    const existingFavorite = await Favorite.findOne({
      user: req.userId,
      product: productId,
    });

    if (existingFavorite) {
      await Favorite.findByIdAndDelete(existingFavorite._id);

      return res.json({
        favorite: false,
        message: "Removed from favorites",
      });
    }

    await Favorite.create({
      user: req.userId,
      product: productId,
    });

    res.json({
      favorite: true,
      message: "Added to favorites",
    });

  } catch (error) {
    res.status(500).json({
      message: error.message,
    });
  }
};

// GET /api/favorites
const getFavorites = async (req, res) => {
  try {

    const favorites = await Favorite.find({
      user: req.userId,
    }).populate("product");

    res.json(favorites);

  } catch (error) {
    res.status(500).json({
      message: error.message,
    });
  }
};

module.exports = {
  toggleFavorite,
  getFavorites,
};