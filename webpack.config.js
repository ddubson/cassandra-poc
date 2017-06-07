const path = require('path');
const ExtractTextPlugin = require('extract-text-webpack-plugin');

const entrySrcFile = "./webapp/src/main.ts";
const entryTestFile = "./webapp/test/test_index.js";
const entryStylesFile = "./webapp/styles/main.scss";

const extractCSS = new ExtractTextPlugin({ filename: '[name].css', allChunks: true });

module.exports = {
    entry: {
        "./src/main/resources/static/scripts/bundle": entrySrcFile,
        "./src/main/resources/static/scripts/styles": entryStylesFile,
        "./webapp/test/bundle/testbundle": entryTestFile
    },
    output: {
        filename: '[name].js',
        libraryTarget: 'var',
        library: ''
    },
    resolve: {
        modules: [
            path.resolve(__dirname, 'webapp'),
            'node_modules'
        ],
        extensions: ['.js', '.ts', '.scss', '.css']
    },
    module: {
        rules: [
            {
                test: /\.[jt]s$/,
                exclude: /node_modules/,
                loader: 'babel-loader',
                options: {
                    presets: ['env']
                }
            },
            {
                test: /\.ts$/,
                loader: 'ts-loader',
                exclude: /node_modules/
            },
            {
                test: /\.scss$/,
                loader: extractCSS
                    .extract({
                        use: ['css-loader', 'sass-loader'],
                        fallback: 'style-loader',
                    })
            }
        ]
    },
    plugins: [extractCSS]
};