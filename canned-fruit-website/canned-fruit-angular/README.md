# CannedFruitAngular

This project was generated using [Angular CLI](https://github.com/angular/angular-cli) version 20.3.5.

## Development server

Install node.js.  A number of websites will guide you, but I find the W3 Schools tutorial most helpful
To start a local development server, go to the top-level directory and run:

```bash or DOS
ng serve --proxy-config proxy-conf.json
```

Once the server is running, open your browser and navigate to `http://localhost:4200/`. The application will automatically reload whenever you modify any of the source files.

## Code scaffolding

Angular CLI includes powerful code scaffolding tools. To generate a new component, run:

```bash
ng generate component component-name
```

For a complete list of available schematics (such as `components`, `directives`, or `pipes`), run:

```bash
ng generate --help
```

## Building

To build the project run:

```bash
ng build
```

This will compile your project and store the build artifacts in the `dist/` directory. By default, the production build optimizes your application for performance and speed.

## Running unit tests

To execute unit tests with the [Karma](https://karma-runner.github.io) test runner, use the following command:

```bash
ng test
```

## Running end-to-end tests

For end-to-end (e2e) testing, run:

```bash
ng e2e
```

Angular CLI does not come with an end-to-end testing framework by default. You can choose one that suits your needs.

## Additional Resources

For more information on using the Angular CLI, including detailed command references, visit the [Angular CLI Overview and Command Reference](https://angular.dev/tools/cli) page.

## About the Application

- *canned-fruit-angular* is the front end of a full stack application that mimics an order site for canned fruit distributor (and who doesn't like canned fruit?).
- It works in concert with *spring-boot-jpa*, a Spring Boot application that in turns works with an RDBMS. 
- There who two types of users: customers and the administrator.  Both login by entering their email ID.  (Homework assignment: implement more secure authentication.)
  - `admin@cannedFruit.com`, who adds, updates and removes shipping terms and offerings, and updates and removes customers
  - customer (logs in with email address).  Adds (AKA registers) herself and orders canned fruit offerings.  She selects which and how many of each item, ship-to address, and the applicable shipping term.  Once those are set, the cost is displayed and she enters her credit/debit card information.  (Homework assignment: make entering the card more like Amazon or Overstock.)

## Administration

### Backup
- Backup only the files in the root directory and those underneath the src/app folder.  It will proceed much faster that way.

## Development
- After finishing a module-based css-html-ts component combination
  1. Add a route to it
  1. Add it to the main app css-html-ts combination (eg. `[root dir]/app.module.ts)`
  1. Update the @Component decorator fields
  1. Go to or create a file that have anchor (a) tags with routerLink in it (eg. [root dir]/main-links/main-links.component.html)
- For a standalone css-html-ts component combination
  - Look at the following files: main.ts, app.routes.ts 

### Beans
- Update a sub-bean within a bean by setting it to a new constructor eg. `newCannedFruit.medium = new Medium(mediumBean.id, mediumBean.name);`

### Default Values
- When setting a select element’s default value via constructing a FormControl, the type must match the value of the options.  And if the value of each option is off a collection, then the default must be a member of that collection.
- When you let a variable’s value in an outer block, then let its value again in an inner block, it retains its original value in the outer block.  Set the variable in the inner block without the let so it retains that value in the outer block.

### Home Page
- Usually specified inside of the @ngModule class (eg. app.module.ts)

### Hiding & Showing HTML Elements
- use WriteableSignal and signal

### Order of Execution
- To ensure lines of code are executed in the order they are typed, surround them with a setTimeout(() => { …}, [milliseconds eg. 1000 for a second]); or see Synchronous vs Asynchronous below

### Services
- You can instantiate a new service by OS-Shell [root directory]> ng generate service [relevant component eg. productSpecs]
- You can do the same with a component in the OS shell [root directory]> ng generate component [component-name] 

### Select and Option
- To assign a default option under a select, put a this.selectedOption = “[value of option]”; eg. “all” where the array that forms the basis for the option is set.
- Also, you may need to have options loop via an \*ngfor construct in the option tag, rather than enclosing all of the option tags in a @for construct

### Collections
- When updating, the lambda-scoped variable can be a simple () if not used.

### Synchronous vs. Asynchronous
- By default, API calls are asynchronous.  Thus any collection assignments don’t survive the code block.  But the example below is synchronous.

```
    await new Promise<void>((resolve) => {
      this.customerSvc.getSomeCustomerNoOrders(businessName, outletName, pocFirst, pocLast).subscribe((data) => {
        console.log('setupForm simple cust data: ', data); //////
        this.abbrevCustomers = data;
        data.map((abbrevCustomer) => {
          ids2.push(abbrevCustomer.id);
          this.namedParams += abbrevCustomer.id + '&id=';
          console.log('ids2 in loop: ', ids2, ' length', ids2.length); //////
        });
        resolve();
      });
    });

```
- Surrounding the code with await new Promise<void>((resolve) => { and resolve }); can also fix where a component property does not render in the HTML

## Issues

### Argument of type 'Event' is not assignable to parameter of type 'Sort'.
- Ensure you have imported the MatSortModule, including your standalone imports

### Cannot Connect with REST Endpoint
- If you cannot connect with a server or service URL via an HTTP request:
- Add a file with extension \*.json (here we will use proxy-conf.json) and have it contain
```
{
     “[proxy eg /backend]”: {
         “Target”: “[root of URL eg. http://localhost:8081]”,
         “Secure”: false
     }
}
```
- Place the file in the root of the application, where you run `ng serve`
- In the root of the application, do at the command prompt  `ng serve --proxy-config [relative path to file eg.proxy-conf.json]`
- You can also edit package.json to make the start element read the same as above and type ng start (though that has not worked for me so far)
- When pushing into a component-scoped array via a loop, read "Synchronous vs Asynchronous” above.  If that does not work, wrap the code block in a `setTimeout(() => { [code block] }, [milliseconds]);`  That will give it time to settle, so it can be read in its entirety later.  
- If your \*.html file has a lot of editor errors to the effect it’s missing a component despite it being imported into the same-folder module file, have the same-folder \*.ts file also be imported in the [rood dir]/app.module.ts file

### Cannot find control with path: '[form array] -> 0'
- With a table form where each row has a control
- Usually it is because you are trying to populate the form off of an empty variable or collection.
- Also, you need to surround the table with a <div formArrayName=”[typescript control array object]”> eg. <div formArrayName="selectedItems">

### Cannot find control with unspecified name
- Often with FormControl, the [FormControlName] should be the component’s array variable applied to the FormControl component object enclosed in single quotes. So `[formControlName]="shippingRadios”` will not work, but  `[formControlName]“‘shippingRadios’”` will.  Then drop the [name] attribute.

### formControlName must be used with a parent formGroup directive
- Try to have on the form the [formControlName] be just the index or a unique transformation of it
- Eg. <tr \*ngFor="let cannedFruit of orderedCannedFruits; even as isEven; let i = index; "> … <select [formControlName]="’’chkbox_’+i" … > (or just “i”)

### JSON.parse does not work with string
- The property names in the string must be surrounded by double-quotes

### Link does not bring you to Page
- Ensure the relative URL (eg. /shippingPrices) is declared in the following places:
- The top-level @NgModule under RouterModule.forRoot as a path:  The component should be the relevant \*.ts file class name, imported in the same file (eg. app.module.ts)
- As an anchor element (<a …>) routerLink value in an HTML document

### NG05104: The selector "[selector name]" did not match any element
- Happens only with standalone components.  The quickest way to resolve is to set the selector to the element used in index.html

### NgForm and NgModel and NG8002
- If you get errors with the above in an HTML form, add the component to above file headed by @NgModule (eg. app.module.ts).  Then it has access to all the resources
- For standalone components, you generally need to @Component/imports only CommonModule and ReactiveForms module

### Reading the console log
- In Edge, press ctrl-shift-j (or ctrl-J (capitalized))

### routerLink does not work
- Ensure you have RouterModule imported

### RuntimeError: NG01203: No value accessor for form control unspecified name attribute
- It it involves a single-object table, then have the table row element use \*ngFor="let object of [object]; instead of ngModel=”object”

### Table just won’t sort by clicking on header
- Ensure your class method for sorting has the case names matching the th element mat-sort-header values.
- Ensure the table element has a `matSort `and a (`matSortChange)="sortData($event)"` attribute
- Ensure the domain of your tr element’s enclosing @for method is the class variable that is returned from the sorting method

## Maintenance
- To add a new library, do DOS> `npm install --legacy-peer-deps [library]`

### Setup
- Install using the W3 schools tutorial.  It installs and runs without issues that way.
- In addition to installing the core project, do these in the project you created:
- `npm install @angular/material @angular/cdk --legacy-peer-deps`

### Needed Libraries
These are the subdirectories under the *node_modules* directory I have; you can compare with your own and search out from the gaps  
- @algolia
- @ampproject
- @angular
- @angular-devkit
- @babel
- @colors
- @esbuild
- @inquirer
- @isaacs
- @istanbuljs
- @jridgewell
- @listr2
- @lmdb
- @modelcontextprotocol
- @msgpackr-extract
- @napi-rs
- @npmcli
- @parcel
- @pkgjs
- @rollup
- @schematics
- @sigstore
- @socket.io
- @tufjs
- @types
- @vitejs
- @yarnpkg
- abbrev
- accepts
- agent-base
- ajv
- ajv-formats
- algoliasearch
- ansi-escapes
- ansi-regex
- ansi-styles
- anymatch
- balanced-match
- base64id
- baseline-browser-mapping
- beasties
- binary-extensions
- body-parser
- boolbase
- brace-expansion
- braces
- browserslist
- buffer-from
- bytes
- cacache
- call-bind-apply-helpers
- call-bound
- caniuse-lite
- chalk
- chardet
- chokidar
- chownr
- cli-cursor
- cli-spinners
- cli-truncate
- cli-width
- cliui
- color-convert
- color-name
- colorette
- concat-map
- connect
- content-disposition
- content-type
- convert-source-map
- cookie
- cookie-signature
- cors
- cross-spawn
- css-select
- css-what
- custom-event
- date-format
- debug
- depd
- destroy
- detect-libc
- di
- dom-serialize
- dom-serializer
- domelementtype
- domhandler
- domutils
- dunder-proto
- eastasianwidth
- ee-first
- electron-to-chromium
- emoji-regex
- encodeurl
- encoding
- engine.io
- engine.io-parser
- ent
- entities
- env-paths
- environment
- err-code
- es-define-property
- es-errors
- es-object-atoms
- esbuild
- escalade
- escape-html
- etag
- eventemitter3
- eventsource
- eventsource-parser
- exponential-backoff
- express
- express-rate-limit
- extend
- fast-deep-equal
- fast-json-stable-stringify
- fast-uri
- fdir
- fill-range
- finalhandler
- flatted
- follow-redirects
- foreground-child
- forwarded
- fresh
- fs-extra
- fs-minipass
- fs.realpath
- function-bind
- gensync
- get-caller-file
- get-east-asian-width
- get-intrinsic
- get-proto
- glob
- glob-parent
- glob-to-regexp
- gopd
- graceful-fs
- has-flag
- has-symbols
- has-tostringtag
- hasown
- hosted-git-info
- html-escaper
- htmlparser2
- http-cache-semantics
- http-errors
- http-proxy
- http-proxy-agent
- https-proxy-agent
- iconv-lite
- ignore-walk
- immutable
- imurmurhash
- inflight
- inherits
- ini
- ip-address
- ipaddr.js
- is-binary-path
- is-core-module
- is-extglob
- is-fullwidth-code-point
- is-glob
- is-interactive
- is-number
- is-promise
- is-regex
- is-unicode-supported
- isbinaryfile
- isexe
- istanbul-lib-coverage
- istanbul-lib-instrument
- istanbul-lib-report
- istanbul-lib-source-maps
- istanbul-reports
- jackspeak
- jasmine-core
- js-tokens
- jsesc
- json-parse-even-better-errors
- json-schema-traverse
- json5
- jsonc-parser
- jsonfile
- jsonparse
- karma
- karma-chrome-launcher
- karma-coverage
- karma-jasmine
- karma-jasmine-html-reporter
- listr2
- lmdb
- lodash
- log-symbols
- log-update
- log4js
- lru-cache
- magic-string
- make-dir
- make-fetch-happen
- math-intrinsics
- media-typer
- merge-descriptors
- micromatch
- mime
- mime-db
- mime-types
- mimic-function
- minimatch
- minimist
- minipass
- minipass-collect
- minipass-fetch
- minipass-flush
- minipass-pipeline
- minipass-sized
- minizlib
- mkdirp
- mrmime
- ms
- msgpackr
- msgpackr-extract
- mute-stream
- nanoid
- negotiator
- node-addon-api
- node-gyp
- node-gyp-build-optional-packages
- node-releases
- nopt
- normalize-path
- npm-bundled
- npm-install-checks
- npm-normalize-package-bin
- npm-package-arg
- npm-packlist
- npm-pick-manifest
- npm-registry-fetch
- nth-check
- object-assign
- object-inspect
- on-finished
- once
- onetime
- ora
- ordered-binary
- p-map
- package-json-from-dist
- pacote
- parse5
- parse5-html-rewriting-stream
- parse5-sax-parser
- parseurl
- path-is-absolute
- path-key
- path-parse
- path-scurry
- path-to-regexp
- picocolors
- picomatch
- piscina
- pkce-challenge
- postcss
- postcss-media-query-parser
- proc-log
- promise-retry
- proxy-addr
- punycode
- qjobs
- qs
- range-parser
- raw-body
- readdirp
- reflect-metadata
- require-directory
- require-from-string
- requires-port
- resolve
- restore-cursor
- retry
- rfdc
- rimraf
- rollup
- router
- rxjs
- safe-buffer
- safe-regex-test
- safer-buffer
- sass
- semver
- send
- serve-static
- setprototypeof
- shebang-command
- shebang-regex
- side-channel
- side-channel-list
- side-channel-map
- side-channel-weakmap
- signal-exit
- sigstore
- slice-ansi
- smart-buffer
- socket.io
- socket.io-adapter
- socket.io-parser
- socks
- socks-proxy-agent
- source-map
- source-map-js
- source-map-support
- spdx-correct
- spdx-exceptions
- spdx-expression-parse
- spdx-license-ids
- ssri
- statuses
- stdin-discarder
- streamroller
- string-width
- string-width-cjs
- strip-ansi
- strip-ansi-cjs
- supports-color
- supports-preserve-symlinks-flag
- tar
- tinyglobby
- tmp
- to-regex-range
- toidentifier
- tslib
- tuf-js
- type-is
- typescript
- ua-parser-js
- undici-types
- unique-filename
- unique-slug
- universalify
- unpipe
- update-browserslist-db
- uri-js
- utils-merge
- validate-npm-package-license
- validate-npm-package-name
- vary
- vite
- void-elements
- watchpack
- weak-lru-cache
- which
- wrap-ansi
- wrap-ansi-cjs
- wrappy
- ws
- xhr2
- y18n
- yallist
- yargs
- yargs-parser
- yoctocolors-cjs
- zod
- zod-to-json-schema
- zone.js
