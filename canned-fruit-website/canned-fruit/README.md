# Getting Started with Create React App

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

The page will reload when you make changes.\
You may also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can't go back!**

If you aren't satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you're on your own.

You don't have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn't feel obligated to use this feature. However we understand that this tool wouldn't be useful if you couldn't customize it when you are ready for it.

## Learn More

You can learn more in the [Create React App documentation](https://facebook.github.io/create-react-app/docs/getting-started).

To learn React, check out the [React documentation](https://reactjs.org/).

### Code Splitting

This section has moved here: [https://facebook.github.io/create-react-app/docs/code-splitting](https://facebook.github.io/create-react-app/docs/code-splitting)

### Analyzing the Bundle Size

This section has moved here: [https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size](https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size)

### Making a Progressive Web App

This section has moved here: [https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app](https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app)

### Advanced Configuration

This section has moved here: [https://facebook.github.io/create-react-app/docs/advanced-configuration](https://facebook.github.io/create-react-app/docs/advanced-configuration)

### Deployment

This section has moved here: [https://facebook.github.io/create-react-app/docs/deployment](https://facebook.github.io/create-react-app/docs/deployment)

### `npm run build` fails to minify

This section has moved here: [https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify](https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify)

# IDE
## VS Code
Type `>Format Document` in the top box to pretty up the code.  Assumes you have the *Prettier* plugin.  Details at [How to Format Code with Pretter Visual Studio Code](https://www.digitalocean.com/community/tutorials/how-to-format-code-with-prettier-in-visual-studio-code)

# canned-fruit application-specific
- The canned-frut application forms the view layer of the total canned-fruit-distributor website.  It works in conjunction with the spring-boot-jpa Java application.
- It is written in React JS.  I strongly suggest you get a good knowledge of the framework before you try to run the application.
- It runs atop node.js; there are several websites telling you how to install and configure that.  I used W3 Schools but there are others.

## IDE 
- I used VSCode, but others may be more suitable for the developer.

## Modules to Install
- Install using `npm install [module]` or `yarn add [module]`  The necessary ones are:
  - react-number-format
  - react-dom
  - react-hook-form
  - react-router-dom
  - @testing-library
  - zod

## Running
- Go to the top directory of the project and type `npm start`

## issues
- If you get a *Can't resolve '@hookform/resolvers/zod'* error, run this in your root directory: `npm i -save-dev @hookform/resolvers`
- If you get a Failed to execute 'createElement' on 'Document': The tag name provided … error, it’s most likely because your file does not have a “.js” extension.
- If a useState variable is not set under useEffect via `set[variable]`, then a possible cause is trying to enter the component directly after having setup routing.  Once you set up routing, you must use it as the main entry point.
await will pause processing until the argument command completes
- If you get a Cannot read properties of … (reading 'map') for what you think should be an array that was set via useState, initialize the variable to an empty array (eg. … `= useState([]);`).  You can check if it worked by checking whether it’s an array by `Array.isArray([variable])` .  If that doesn’t work, use `targetArray = [...targetArray, ...sourceArray];` (which technically appends)
- If you get an Expected corresponding JSX closing tag for … you have to provide a closing tag or at least a /> for HTML tags that ordinarily don’t need one, such as `<br>`. 
- If you get a Not Found especially in your IDE, you may need to run npm i @types/react@latest --save-dev
- If you get a Type 'string' is not assignable to type 'number' then the argument should be surrounded by curly brackets ( { } ) rather than quotes
- If you get an expression expected in a closing parentheses or bracket, it could be because the previous line has the wrong closing punctuation.
- If you get a 'react-scripts' is not recognized as an internal or external command, operable program or batch file then do a npm install react-scripts –save 
- If you get a Cannot destructure property 'basename' of 'react__WEBPACK_IMPORTED_MODULE_0__.useContext(...)' as it is null it is most likely because you did not wrap a root.render tag argument inside a MemoryRouter element. (The latter is imported via react-router-dom
- If you get a Failed to execute 'removeChild' on 'Node': The node to be removed is not a child of this node. error in React.js, it could be that you are asking the root element to render something that is inconsistent with what it already has.  So you may need to redefine the root variable (eg. `root = ReactDOM.createRoot(document.getElementById("root"));`) so it is blank.  
- If your root.render takes you to a function other than what you expect, ensure there’s not refreshing or redirection commands (eg. `window.location.href = href;`) afterwards.
- __Never__ run `npm audit fix --force`.  Then you have to reinstall the project.

