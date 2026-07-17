require("dotenv").config();
const mongoose = require("mongoose");

const connectDB = require("./config/db");
const Product = require("./models/Product");
const products = require("./data/products");

const seedDatabase = async () => {
    try {
        await connectDB();

        await Product.deleteMany();

        await Product.insertMany(products);

        console.log("Database Seeded Successfully");

        process.exit();
    } catch (error) {
        console.error(error);
        process.exit(1);
    }
};

seedDatabase();