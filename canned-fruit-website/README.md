# Application Overview
- canned-fruit-distributor is a web application you may run entirely on your laptop that mimics a canned fruit order taker.  The business distributes canned fruit, primarily to other businesses. (The application is agnostic to how the distributor obtains it.)

# Types of users
## Administrator
  - login is *admin@cannedFruit.com*) 
  She creates, maintains and removes 
    - Offerings (fruit that is sold in a medium, such as syrup, and in a container), and its price per ounce.
    - Shipping Terms (How quickly to deliver the order and how much that timeframe will cost, per ounce.)
    - Customers, generally supermarkets or restaurants.  For now, administrators add customers but customers adding themselves is a future enhancement.  Each customer has one or more addresses.
## Customers
  - Enters an order.  An order consists of:
  - One or more offerings and what count of each offering to order.
  - Ship to address
  - Shipping Term, that is, in how many days to deliver and the cost per ounce therein.
- Identified by her email address

# Technological Stack

## Database
- Either connect with a remote database or install a local one.  I used PostgreSQL, but you may try another.
- Whichever one you use, install the appropriate driver in the middleware and set its *application.properties* file accordingly

## Middleware
- A Spring Boot Hibernate JPA Java application called *spring-boot-jpa*. It exposes port 8081, but you can alter that in *application.properties*
- You can run it via Spring Boot.  Details are in its own README.md file

## View Layer
- You may use either (but not both at once) the React JS or the Angular application.  (The Angular application is more full-featured.)

### React JS
- A React JS application called *canned-fruit*.  It runs on node.js via the `npm start` command.  It exposes port 3000.

### Angular
- An Angular application called *canned-fruit-angular*.  It runs on node.js via the `ng serve --proxy-config proxy-conf.json` command.
- Install using the W3 schools tutorial.  It installs and runs without issues that way.
- In addition to installing the core project, you will need to install libraries.  You may do it either of (or a mix of) two ways:
  - Open the code in an intelligent IDE, such as VSCode with plugins, and see which imported libraries it cannot find.
  - Check the directory listing under the README.md *canned-fruit-angular* project and compare with what you have under the *node_modules* subdirectory.

### VSCode
- For per-project or workspace-specific themes:
  - Open your project folder in VS Code.
  - Go to File > Preferences > Settings.
  - Select the Workspace tab.
  - Search for colorTheme.
  - Choose the desired theme from the dropdown menu. This will create a settings.json file within your project's .vscode folder, storing the workspace-specific theme setting.
- To indent a block of code, press *Ctrl-]*
	  
	  
