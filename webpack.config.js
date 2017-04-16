var path = require('path'),
    srcPath = path.join(__dirname, 'webpack/src'),
    outPath = path.join(__dirname, 'src/main/resources/static');

module.exports = {
    entry: path.join(srcPath, 'main.ts'),
    output: {
        path: outPath,
        filename: 'bundle.js'
    },
    resolve: {
        extensions: ['.js', '.ts']
    },
    module: {
        rules: [
            {test: /\.[jt]s$/, exclude: /node_modules/, loaders: ["babel-loader", "ts-loader"]},
            {test: /\.css$/, loaders: 'style-loader!css-loader'}
        ]
    }
};