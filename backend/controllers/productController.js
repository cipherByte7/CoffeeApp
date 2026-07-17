const Product = require("../models/Product");

const getProducts = async (req, res) => {

    try {

        const search = req.query.search
        const category = req.query.category

        let filter = {}

        if (search) {
            filter.name = {
                $regex: search,
                $options: "i"
            }
        }

        if (category) {
            filter.category = category
        }

        const products = await Product.find(filter)

        res.json(products)

    } catch (err) {

        res.status(500).json({
            message: err.message
        })

    }
}

const getProductById = async (req, res) => {
    try {

        const product = await Product.findById(req.params.id);

        if (!product) {
            return res.status(404).json({
                message: "Product not found"
            });
        }

        res.status(200).json(product);

    } catch (error) {

        res.status(500).json({
            message: error.message
        });

    }
};

module.exports = {
    getProducts,
    getProductById
};