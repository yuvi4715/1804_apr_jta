webpackJsonp(["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/app-routing.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppRoutingModule; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return routingComponents; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__test_test_component__ = __webpack_require__("./src/app/test/test.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__register_component_register_component_component__ = __webpack_require__("./src/app/register-component/register-component.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__login_component_login_component_component__ = __webpack_require__("./src/app/login-component/login-component.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__receipt_generate_receipt_generate_component__ = __webpack_require__("./src/app/receipt-generate/receipt-generate.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__view_employee_view_employee_component__ = __webpack_require__("./src/app/view-employee/view-employee.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};







var routes = [
    {
        path: 'main',
        component: __WEBPACK_IMPORTED_MODULE_2__test_test_component__["a" /* TestComponent */]
    },
    {
        path: 'register',
        component: __WEBPACK_IMPORTED_MODULE_3__register_component_register_component_component__["a" /* RegisterComponentComponent */]
    },
    {
        path: '',
        component: __WEBPACK_IMPORTED_MODULE_4__login_component_login_component_component__["a" /* LoginComponentComponent */]
    },
    {
        path: 'receiptRegister',
        component: __WEBPACK_IMPORTED_MODULE_5__receipt_generate_receipt_generate_component__["a" /* ReceiptGenerateComponent */]
    },
    {
        path: 'viewEmployees',
        component: __WEBPACK_IMPORTED_MODULE_6__view_employee_view_employee_component__["a" /* ViewEmployeeComponent */]
    },
    {
        path: '**', redirectTo: '', pathMatch: 'full'
    }
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["I" /* NgModule */])({
            imports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* RouterModule */].forRoot(routes)],
            exports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* RouterModule */]]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());

var routingComponents = [__WEBPACK_IMPORTED_MODULE_2__test_test_component__["a" /* TestComponent */], __WEBPACK_IMPORTED_MODULE_3__register_component_register_component_component__["a" /* RegisterComponentComponent */], __WEBPACK_IMPORTED_MODULE_4__login_component_login_component_component__["a" /* LoginComponentComponent */], __WEBPACK_IMPORTED_MODULE_5__receipt_generate_receipt_generate_component__["a" /* ReceiptGenerateComponent */], __WEBPACK_IMPORTED_MODULE_6__view_employee_view_employee_component__["a" /* ViewEmployeeComponent */]];


/***/ }),

/***/ "./src/app/app.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<router-outlet></router-outlet>\n"

/***/ }),

/***/ "./src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AppComponent = /** @class */ (function () {
    function AppComponent() {
        this.title = 'app';
    }
    AppComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-root',
            template: __webpack_require__("./src/app/app.component.html"),
            styles: [__webpack_require__("./src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("./node_modules/@angular/platform-browser/esm5/platform-browser.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__("./node_modules/@angular/forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__app_component__ = __webpack_require__("./src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__database_getter_service__ = __webpack_require__("./src/app/database-getter.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__app_routing_module__ = __webpack_require__("./src/app/app-routing.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__view_employee_view_employee_component__ = __webpack_require__("./src/app/view-employee/view-employee.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};








var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["I" /* NgModule */])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_4__app_component__["a" /* AppComponent */],
                __WEBPACK_IMPORTED_MODULE_6__app_routing_module__["b" /* routingComponents */],
                __WEBPACK_IMPORTED_MODULE_7__view_employee_view_employee_component__["a" /* ViewEmployeeComponent */]
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
                __WEBPACK_IMPORTED_MODULE_2__angular_forms__["a" /* FormsModule */],
                __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClientModule */],
                __WEBPACK_IMPORTED_MODULE_6__app_routing_module__["a" /* AppRoutingModule */]
            ],
            providers: [__WEBPACK_IMPORTED_MODULE_5__database_getter_service__["a" /* DatabaseGetterService */]],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_4__app_component__["a" /* AppComponent */]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/database-getter.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DatabaseGetterService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_Observable__ = __webpack_require__("./node_modules/rxjs/_esm5/Observable.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_catch__ = __webpack_require__("./node_modules/rxjs/_esm5/add/operator/catch.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_rxjs_add_observable_throw__ = __webpack_require__("./node_modules/rxjs/_esm5/add/observable/throw.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var DatabaseGetterService = /** @class */ (function () {
    function DatabaseGetterService(http, router) {
        this.http = http;
        this.router = router;
        this.endpoint = 'http://localhost:8080/ProjectOne/fc/';
        this.isAdmin = false;
    }
    DatabaseGetterService.prototype.getReceipts = function (page, getActivated) {
        return this.http.get(this.endpoint + '?format=json&page=' + page + '&getAproved=' + getActivated, {
            headers: { 'command': 'GetRequestReceipts' }
        })
            .catch(this.errorHandler);
    };
    DatabaseGetterService.prototype.getEmployees = function (page) {
        return this.http.get(this.endpoint + '?format=json&page=' + page, {
            headers: { 'command': 'GetAllEmployees' }
        })
            .catch(this.errorHandler);
    };
    DatabaseGetterService.prototype.errorHandler = function (error) {
        console.log(error);
        return __WEBPACK_IMPORTED_MODULE_2_rxjs_Observable__["a" /* Observable */].throw(error.message || 'Server Error');
    };
    DatabaseGetterService.prototype.logoutUser = function () {
        var _this = this;
        return this.http.get(this.endpoint + '?format=json', {
            headers: { 'command': 'LogOut' }
        }).subscribe(function (data) {
            console.log(data);
            _this.router.navigateByUrl('/');
        }, function (error) {
            _this.errorMsg = error;
            _this.router.navigateByUrl('/');
        });
    };
    DatabaseGetterService.prototype.search = function (checked, query, page) {
        var formData = new FormData();
        formData.append("format", "json");
        formData.append("getAproved", checked);
        formData.append("query", query);
        formData.append("page", page);
        var temp = this.http.post(this.endpoint, formData, { headers: { 'command': 'SearchCommand' } });
        return temp;
    };
    DatabaseGetterService.prototype.loginUser = function (email, password, checked) {
        var _this = this;
        var formData = new FormData();
        formData.append("format", "json");
        formData.append("email", email);
        formData.append("password", password);
        formData.append("checked", checked);
        var temp = this.http.post(this.endpoint, formData, { headers: { 'command': 'ProcessLoginPost' } });
        temp.subscribe(function (data) {
            console.log(data);
            _this.user = data['employee'];
            if (_this.user == null) {
                _this.user = data['manager'];
                if (_this.user != null)
                    _this.isAdmin = true;
            }
            else
                _this.isAdmin = false;
            console.log(_this.user);
            if (_this.user['email'] === email)
                _this.router.navigateByUrl('/main');
        }, function (error) { return _this.errorMsg = error; });
        return temp;
    };
    DatabaseGetterService.prototype.postFile = function (fileToUpload, amount, description) {
        var formData = new FormData();
        formData.append("format", "json");
        formData.append("amount", amount);
        formData.append("description", description);
        formData.append('image', fileToUpload, fileToUpload.name);
        return this.http.post(this.endpoint, formData, { headers: { "command": "UploadReinbursementReceipt" } })
            .catch(this.errorHandler);
    };
    DatabaseGetterService.prototype.postEmployee = function (email, fname, lname, password) {
        var formData = new FormData();
        formData.append("format", "json");
        formData.append("email", email);
        formData.append("fname", fname);
        formData.append("lname", lname);
        formData.append("password", password);
        return this.http.post(this.endpoint, formData, { headers: { "command": "UploadEmployee" } })
            .catch(this.errorHandler);
    };
    DatabaseGetterService.prototype.postReinbursementRequest = function (id, status) {
        var formData = new FormData();
        formData.append("format", "json");
        formData.append("status", status);
        formData.append("id", id);
        return this.http.post(this.endpoint, formData, { headers: { "command": "UpdateReinbursementReceipt" } })
            .catch(this.errorHandler);
    };
    DatabaseGetterService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["A" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["a" /* HttpClient */], __WEBPACK_IMPORTED_MODULE_5__angular_router__["a" /* Router */]])
    ], DatabaseGetterService);
    return DatabaseGetterService;
}());



/***/ }),

/***/ "./src/app/login-component/login-component.component.css":
/***/ (function(module, exports) {

module.exports = "#loadingImage {\r\n\tdisplay:\"none\";\r\n\twidth:30px;\r\n}"

/***/ }),

/***/ "./src/app/login-component/login-component.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container pt-3\">\n  <div class=\"row justify-content-sm-center\">\n    <div class=\"col-sm-6 col-md-4\">\n\n      <div class=\"card border-info text-center\">\n        <div class=\"card-header\" >\n          Sign in to continue\n\t\t  <img id=\"loadingImage\" #loadingImage src=\"data:image/gif;base64,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\" />\n\t\t</div>\n        <div class=\"card-body\">\n          <form class=\"form-signin\">\n            <input type=\"text\" #myEmail class=\"form-control mb-2\" placeholder=\"Email\" required autofocus>\n            <input type=\"password\" #myPassword class=\"form-control mb-2\" placeholder=\"Password\" required>\n            <button (click)=\"loginSubmit(myEmail.value,myPassword.value,myCheckbox.checked,loadingImage,submitButton); false\" #submitButton class=\"btn btn-lg btn-primary btn-block mb-1\" type=\"submit\">Sign in</button>\n            <a href=\"#\" (click)=\"checkboxIsClicked(myCheckbox); false\" class=\"float-right\"><input #myCheckbox type=\"checkbox\" />Login as Admin</a>\n          </form>\n        </div>\n      </div>\n    </div>\n  </div>\n</div>\n<div class=\"lds-dual-ring\"></div>"

/***/ }),

/***/ "./src/app/login-component/login-component.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LoginComponentComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__database_getter_service__ = __webpack_require__("./src/app/database-getter.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var LoginComponentComponent = /** @class */ (function () {
    function LoginComponentComponent(_databaseService) {
        this._databaseService = _databaseService;
        this.errorMsg = "";
    }
    LoginComponentComponent.prototype.ngOnInit = function () {
    };
    LoginComponentComponent.prototype.loginSubmit = function (email, password, checked, loadingImage, submitButton) {
        var _this = this;
        if (loadingImage.style.display === "none") {
            loadingImage.style.display = "block";
            submitButton.disabled = true;
        }
        console.log(email);
        console.log(password);
        this._databaseService.loginUser(email, password, checked).subscribe(function (data) {
            loadingImage.style.display = "none";
            submitButton.disabled = false;
            console.log(data);
        }, function (error) {
            loadingImage.style.display = "none";
            submitButton.disabled = false;
            _this.errorMsg = error;
        });
    };
    LoginComponentComponent.prototype.checkboxIsClicked = function (myCheckbox) {
        myCheckbox.checked = !myCheckbox.checked;
    };
    LoginComponentComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-login-component',
            template: __webpack_require__("./src/app/login-component/login-component.component.html"),
            styles: [__webpack_require__("./src/app/login-component/login-component.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__database_getter_service__["a" /* DatabaseGetterService */]])
    ], LoginComponentComponent);
    return LoginComponentComponent;
}());



/***/ }),

/***/ "./src/app/receipt-generate/receipt-generate.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/receipt-generate/receipt-generate.component.html":
/***/ (function(module, exports) {

module.exports = "<nav class=\"navbar navbar-dark bg-dark\">\n  <a class=\"navbar-brand\" (click)=\"logout(); false\" href=\"#\" >Log Out</a>\n  <a class=\"navbar-brand\" id=\"back\" (click)=\"back(); false\" href=\"#\" >Back</a>\n</nav>\n<div class=\"container pt-3\">\n  <div class=\"row justify-content-sm-center\">\n    <div class=\"col-sm-6 col-md-4\">\n\n      <div class=\"card border-info text-center\">\n        <div class=\"card-header\">\n          Enter Amount and a photo of the receipt({{this.status}})\n        </div>\n        <div class=\"card-body\">\n          <form class=\"form-createreceipt\" id=\"usrform\" enctype=\"multipart/form-data\">\n            <input type=\"number\" class=\"form-control mb-2\" #Amount name=\"amount\" placeholder=\"amount\" required autofocus>\n            <!-- COMPONENT START -->\n\t\t\t<div class=\"form-group\">\n\t\t\t\t<div class=\"input-group input-file\" name=\"Fichier1\">\n\t\t\t\t\t<span class=\"input-group-btn\">\n\t\t\t\t\t\t<input class=\"btn btn-default btn-choose\" name=\"file\" type=\"file\" (change)=\"handleFileInput($event.target.files)\">\n\t\t\t\t\t</span>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<textarea name=\"description\" form=\"usrform\" #Description placeholder=\"description\"></textarea>\n            <button class=\"btn btn-lg btn-primary btn-block mb-1\"  (click)=\"onSubmit(Amount,Description);false\" type=\"submit\">Upload</button>\n          </form>\n        </div>\n      </div>\n    </div>\n  </div>\n</div>"

/***/ }),

/***/ "./src/app/receipt-generate/receipt-generate.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ReceiptGenerateComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__database_getter_service__ = __webpack_require__("./src/app/database-getter.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ReceiptGenerateComponent = /** @class */ (function () {
    function ReceiptGenerateComponent(_databaseService, router) {
        this._databaseService = _databaseService;
        this.router = router;
        this.fileToUpload = null;
        this.status = "idle";
    }
    ReceiptGenerateComponent.prototype.ngOnInit = function () {
    };
    ReceiptGenerateComponent.prototype.back = function () {
        console.log("Back");
        this.router.navigateByUrl('/main');
    };
    ReceiptGenerateComponent.prototype.logout = function () {
        this._databaseService.logoutUser();
        console.log("LogOut");
    };
    ReceiptGenerateComponent.prototype.onSubmit = function (Amount, Description) {
        var _this = this;
        if (this.fileToUpload == null) {
            Amount.disabled = false;
            Description.disabled = false;
            this.status = "pending";
        }
        Amount.disabled = true;
        Description.disabled = true;
        this.status = "loading";
        console.log(Amount.value);
        console.log(Description.value);
        this._databaseService.postFile(this.fileToUpload, Amount.value, Description.value).subscribe(function (data) {
            // do something, if upload success
            Amount.disabled = false;
            Description.disabled = false;
            _this.status = "idle";
            console.log(data);
            console.log("upload finished");
        }, function (error) {
            Amount.disabled = false;
            Description.disabled = false;
            _this.status = "idle";
            console.log(error);
        });
    };
    ReceiptGenerateComponent.prototype.handleFileInput = function (files) {
        this.fileToUpload = files.item(0);
    };
    ReceiptGenerateComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-receipt-generate',
            template: __webpack_require__("./src/app/receipt-generate/receipt-generate.component.html"),
            styles: [__webpack_require__("./src/app/receipt-generate/receipt-generate.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__database_getter_service__["a" /* DatabaseGetterService */], __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* Router */]])
    ], ReceiptGenerateComponent);
    return ReceiptGenerateComponent;
}());



/***/ }),

/***/ "./src/app/register-component/register-component.component.css":
/***/ (function(module, exports) {

module.exports = ".main{\r\n \tmargin-top: 70px;\r\n}\r\n\r\nh1.title { \r\n\tfont-size: 50px;\r\n\tfont-family: 'Passion One', cursive; \r\n\tfont-weight: 400; \r\n}\r\n\r\nhr{\r\n\twidth: 10%;\r\n\tcolor: #fff;\r\n}\r\n\r\n.form-group{\r\n\tmargin-bottom: 15px;\r\n}\r\n\r\nlabel{\r\n\tmargin-bottom: 15px;\r\n}\r\n\r\ninput,\r\ninput::-webkit-input-placeholder {\r\n    font-size: 11px;\r\n    padding-top: 3px;\r\n}\r\n\r\n.main-login{\r\n \tbackground-color: #fff;\r\n    /* shadows and rounded borders */\r\n    border-radius: 2px;\r\n    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);\r\n    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);\r\n\r\n}\r\n\r\n.main-center{\r\n \tmargin-top: 30px;\r\n \tmargin: 0 auto;\r\n \tmax-width: 330px;\r\n    padding: 40px 40px;\r\n\r\n}\r\n\r\n.login-button{\r\n\tmargin-top: 5px;\r\n}\r\n\r\n.login-register{\r\n\tfont-size: 11px;\r\n\ttext-align: center;\r\n}\r\n"

/***/ }),

/***/ "./src/app/register-component/register-component.component.html":
/***/ (function(module, exports) {

module.exports = "<nav class=\"navbar navbar-dark bg-dark\">\n  <a class=\"navbar-brand\" (click)=\"logout(); false\" href=\"#\" >Log Out</a>\n  <a class=\"navbar-brand\" id=\"back\" (click)=\"back(); false\" href=\"#\" >Back</a>\n</nav>\n\t<div class=\"container\">\n\t\t\t<div class=\"row main\">\n\t\t\t\t<div class=\"panel-heading\">\n\t            </div> \n\t\t\t\t<div class=\"main-login main-center\">\n\t\t\t\t\t<form class=\"form-horizontal\" method=\"post\" action=\"#\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t<div class=\"form-group\">\n\t\t\t\t\t\t\t<label for=\"email\" class=\"cols-sm-2 control-label\">Email</label>\n\t\t\t\t\t\t\t<div class=\"cols-sm-10\">\n\t\t\t\t\t\t\t\t<div class=\"input-group\">\n\t\t\t\t\t\t\t\t\t<span class=\"input-group-addon\"><i class=\"fa fa-envelope fa\" aria-hidden=\"true\"></i></span>\n\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" #email name=\"email\" id=\"email\"  placeholder=\"Enter the Email\"/>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t<div class=\"form-group\">\n\t\t\t\t\t\t\t<label for=\"username\" class=\"cols-sm-2 control-label\">First Name</label>\n\t\t\t\t\t\t\t<div class=\"cols-sm-10\">\n\t\t\t\t\t\t\t\t<div class=\"input-group\">\n\t\t\t\t\t\t\t\t\t<span class=\"input-group-addon\"><i class=\"fa fa-users fa\" aria-hidden=\"true\"></i></span>\n\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" #fname name=\"fname\" id=\"fname\"  placeholder=\"Enter the First name\"/>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t<div class=\"form-group\">\n\t\t\t\t\t\t\t<label for=\"username\" class=\"cols-sm-2 control-label\">Last Name</label>\n\t\t\t\t\t\t\t<div class=\"cols-sm-10\">\n\t\t\t\t\t\t\t\t<div class=\"input-group\">\n\t\t\t\t\t\t\t\t\t<span class=\"input-group-addon\"><i class=\"fa fa-users fa\" aria-hidden=\"true\"></i></span>\n\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" #lname name=\"lname\" id=\"lname\"  placeholder=\"Enter the Last name\"/>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<div class=\"form-group\">\n\t\t\t\t\t\t\t<label for=\"password\" class=\"cols-sm-2 control-label\">Password</label>\n\t\t\t\t\t\t\t<div class=\"cols-sm-10\">\n\t\t\t\t\t\t\t\t<div class=\"input-group\">\n\t\t\t\t\t\t\t\t\t<span class=\"input-group-addon\"><i class=\"fa fa-lock fa-lg\" aria-hidden=\"true\"></i></span>\n\t\t\t\t\t\t\t\t\t<input type=\"password\" class=\"form-control\" #password name=\"password\" id=\"password\"  placeholder=\"Enter the Password\"/>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t<div class=\"form-group\">\n\t\t\t\t\t\t\t<label for=\"confirm\" class=\"cols-sm-2 control-label\">Confirm Password</label><span style=\"font-size: 10px;\"> {{status}}</span>\n\t\t\t\t\t\t\t<div class=\"cols-sm-10\">\n\t\t\t\t\t\t\t\t<div class=\"input-group\">\n\t\t\t\t\t\t\t\t\t<span class=\"input-group-addon\"><i class=\"fa fa-lock fa-lg\" aria-hidden=\"true\"></i></span>\n\t\t\t\t\t\t\t\t\t<input type=\"password\" class=\"form-control\" #confirm name=\"confirm\" id=\"confirm\"  placeholder=\"Confirm the Password\"/>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t<div class=\"form-group \">\n\t\t\t\t\t\t\t<button type=\"button\" (click)=\"onSubmit(email,fname,lname,password,confirm);false\"class=\"btn btn-primary btn-lg btn-block login-button\">Register</button>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</form>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>"

/***/ }),

/***/ "./src/app/register-component/register-component.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return RegisterComponentComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__database_getter_service__ = __webpack_require__("./src/app/database-getter.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var RegisterComponentComponent = /** @class */ (function () {
    function RegisterComponentComponent(_databaseService, router) {
        this._databaseService = _databaseService;
        this.router = router;
    }
    RegisterComponentComponent.prototype.ngOnInit = function () {
    };
    RegisterComponentComponent.prototype.logout = function () {
        this._databaseService.logoutUser();
        console.log("LogOut");
    };
    RegisterComponentComponent.prototype.back = function () {
        console.log("Back");
        this.router.navigateByUrl('/main');
    };
    RegisterComponentComponent.prototype.onSubmit = function (email, fname, lname, password, confirm) {
        var _this = this;
        if (password.value !== confirm.value) {
            this.status = "passwords dont match";
            return;
        }
        this.status = null;
        email.disabled = true;
        fname.disabled = true;
        lname.disabled = true;
        password.disabled = true;
        confirm.disabled = true;
        this._databaseService.postEmployee(email.value, fname.value, lname.value, password.value).subscribe(function (data) {
            console.log(data);
            _this.status = null;
            email.disabled = false;
            fname.disabled = false;
            lname.disabled = false;
            password.disabled = false;
            confirm.disabled = false;
        }, function (error) {
            console.log(error);
            _this.status = null;
            email.disabled = false;
            fname.disabled = false;
            lname.disabled = false;
            password.disabled = false;
            confirm.disabled = false;
        });
    };
    RegisterComponentComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-register-component',
            template: __webpack_require__("./src/app/register-component/register-component.component.html"),
            styles: [__webpack_require__("./src/app/register-component/register-component.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__database_getter_service__["a" /* DatabaseGetterService */], __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* Router */]])
    ], RegisterComponentComponent);
    return RegisterComponentComponent;
}());



/***/ }),

/***/ "./src/app/test/test.component.css":
/***/ (function(module, exports) {

module.exports = "\r\n.rounded {\r\n  border-radius: 10px;\r\n  background: rgba(100,100,100); \r\n}\r\n.right {\r\n    position: absolute;\r\n    right: 0px;\r\n}\r\n#receiptImage{\r\n\twidth:250px;\r\n}\r\n#image {\r\n    display: block;\r\n    margin-left: auto;\r\n    margin-right: auto;\r\n    width: 50%;\r\n}\r\n#image textarea{\r\n    min-width: 200px;\r\n}\r\n#receiptContainer {\r\n\tdisplay:block;\r\n\tposition:absolute;\r\n\tleft:33%;\r\n\twidth:33%;\r\n\tmin-width:400px;\r\n}\r\n#searchbar{\r\n\tbackground:#fff no-repeat 13px 13px;\r\n\tbackground-image:url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyBpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMC1jMDYwIDYxLjEzNDc3NywgMjAxMC8wMi8xMi0xNzozMjowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBXaW5kb3dzIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkU5NEY0RTlFMTA4NzExRTM5RTEzQkFBQzMyRjkyQzVBIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkU5NEY0RTlGMTA4NzExRTM5RTEzQkFBQzMyRjkyQzVBIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6RTk0RjRFOUMxMDg3MTFFMzlFMTNCQUFDMzJGOTJDNUEiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6RTk0RjRFOUQxMDg3MTFFMzlFMTNCQUFDMzJGOTJDNUEiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz4DjA/RAAABK0lEQVR42pTSQUdEURjG8dOY0TqmPkGmRcqYD9CmzZAWJRHVRIa0iFYtM6uofYaiEW2SRJtEi9YxIklp07ZkWswu0v/wnByve7vm5ee8M+85zz1jbt9Os+WiGkYdYxjCOx5wgFeXUHmtBSzpcCGa+5BJTCjEP+0nKWAT8xqe4ArPGEEVC1hHEbs2oBwdXkM7mj/JLZrad437sCGHOfUtcziutuYu2v8XUFF/4f6vMK/YgAH1HxkBYV60AR31gxkBYd6xAeF3VzMCwvzOBpypX8V4yuFRzX2d2gD/l5yjH4fYQEnzkj4fae5rJulF2sMXVrAsaTWttRFu4Osb+1jEDT71/ZveyhouTch2fINQL9hKefKjuYFfuznXWzXMTabyrvfyIV3M4vhXgAEAUMs7K0J9UJAAAAAASUVORK5CYII=);\r\n\tborder: none;\r\n\tmin-width: 250px;\r\n\tline-height: 19px;\r\n\tpadding: 11px 0;\r\n\r\n\tborder-radius: 2px;\r\n\t-webkit-box-shadow: 0 2px 8px #c4c4c4 inset;\r\n\t        box-shadow: 0 2px 8px #c4c4c4 inset;\r\n\ttext-align: left;\r\n\tfont-size: 14px;\r\n\tfont-family: inherit;\r\n\tcolor: #738289;\r\n\tfont-weight: bold;\r\n\toutline: none;\r\n\ttext-indent: 40px;\r\n}\r\n.bar {\r\n\tdisplay:block;\r\n\tposition:absolute;\r\n\tleft:33%;\r\n\twidth:23%;\r\n\tmin-width:400px;\r\n\tz-index:10;\r\n}\r\n"

/***/ }),

/***/ "./src/app/test/test.component.html":
/***/ (function(module, exports) {

module.exports = "\n<!-- As a link -->\n<nav class=\"navbar navbar-dark bg-dark\">\n  <a class=\"navbar-brand\" (click)=\"logout(); false\" href=\"#\" >Log Out</a>\n  <div *ngIf='this._databaseService.isAdmin; else elseBlockZero'>\n\t  <a class=\"navbar-brand\" id=\"viewemployee\" (click)=\"viewEmployee(); false\" href=\"#\" >View Employees</a>\n\t  <a class=\"navbar-brand\" id=\"register\" (click)=\"registerNewUser(); false\" href=\"#\" >Register New Employee</a>\n  </div>\n  <ng-template #elseBlockZero>\n\t  <a class=\"navbar-brand\" id=\"generateReceipt\" (click)=\"generateReceipt(); false\" href=\"#\" >Generate Receipt</a>\n  </ng-template>\n</nav>\n\n<h1 style=\"text-align: center;\">Welcome to Ipsum Receipt Tracker!</h1>\n<div class=\"bar\">\n<input [(ngModel)]=\"name\" id=\"searchbar\"type=\"text\" #mySearchbar (keyup)=\"onKey($event,!myCheckbox.checked,mySearchbar.value,mySearchbar)\" placeholder=\"Enter your search terms\"/>\n<a (click)=\"checkboxIsClicked(myCheckbox); false\" href=\"#\" ><input #myCheckbox type=\"checkbox\" />Display Approved</a>\n</div>\n<br/>\n<br/>\n<div id=\"receiptContainer\" class=\"align-items-center\">\n\t{{errorMsg}}\n\t<div *ngFor=\"let receipt of receipts\">\n\t\t<div class=\"rounded\" id=\"container\">\n\t\t\t<input disabled=true [checked]=\"receipt.reinbursementRequest.status>0\" id=\"checkbox\" type=\"checkbox\"/>\n\t\t\t<div class=\"right\" id=\"amount\">\n\t\t\t\tAmount:${{receipt.reinbursementRequest.amount}}\n\t\t\t</div>\n\t\t\t<div id=\"info\">\n\t\t\t\tStatus:{{receipt.reinbursementRequest.status==0?\"unresolved\":receipt.reinbursementRequest.status==1?\"Aproved\":\"Denied\"}}<br/>\n\t\t\t\tReceiptID:{{receipt.reinbursementRequest.id}}<br/>\n\t\t\t\tEmployee:{{receipt.reinbursementRequest.owner.fname}}<br/>\n\t\t\t\tManager:{{receipt.reinbursementRequest.handledBy!=null?receipt.reinbursementRequest.handledBy.fname:\"Unhandled\"}}<br/>\n\t\t\t</div>\n\t\t\t<div id=\"image\">\n\t\t\t\t<img id=\"receiptImage\" src=\"{{receipt.reinbursementRequest.imageURL}}\" align=\"middle\"/>\n\t\t\t\t<textarea name=\"description\" form=\"usrform\" disabled=\"disabled\" placeholder=\"description\">{{receipt.reinbursementRequest.description}}</textarea>\n\t\t\t</div>\n\t\t\t<div *ngIf='this._databaseService.isAdmin'>\n\t\t\t\t<div *ngIf='receipt.reinbursementRequest.status==0; else elseBlock'>\n\t\t\t\t\t<button (click)=\"onAprove(receipt.reinbursementRequest)\" type=\"button\" class=\"btn btn-success\">Aprove</button>\n\t\t\t\t\t<button (click)=\"onDeny(receipt.reinbursementRequest)\" type=\"button\" class=\"btn btn-danger right\">Deny</button>\n\t\t\t\t</div>\n\t\t\t\t<ng-template #elseBlock>\n\t\t\t\t\t<div>\n\t\t\t\t\t\t<button (click)=\"onChange(receipt.reinbursementRequest)\" type=\"button\" class=\"btn btn-primary\">Change</button>\n\t\t\t\t\t</div>\n\t\t\t\t</ng-template>\n\t\t\t</div>\n\t\t</div>\n\t\t<br/>\n\t</div>\n\t<br/>\n<button (click)=\"onPreviousPage()\" style=\"left:33%\" type=\"button\" class=\"btn btn-primary\">Previous Page</button>\n<span>Page Number:{{this.page}}</span>\n<button (click)=\"onNextPage()\" type=\"button\" class=\"btn btn-primary right\">Next Page</button>\n{{this.getActivatedOnly}}\n</div>\n"

/***/ }),

/***/ "./src/app/test/test.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TestComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__database_getter_service__ = __webpack_require__("./src/app/database-getter.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var TestComponent = /** @class */ (function () {
    function TestComponent(_databaseService, router) {
        this._databaseService = _databaseService;
        this.router = router;
        this.receipts = [];
        this.page = 0;
        this.getApproved = false;
        this.ENTERKEYCODE = 13;
    }
    TestComponent.prototype.ngOnInit = function () {
        var _this = this;
        this._databaseService.getReceipts(this.page, this.getApproved).subscribe(function (data) { return _this.receipts = data; }, function (error) { return _this.errorMsg = error; });
    };
    TestComponent.prototype.onKey = function (event, checked, query, mySearchbar) {
        var _this = this;
        if (event.keyCode == this.ENTERKEYCODE) {
            mySearchbar.disabled = true;
            this._databaseService.search(checked, query, this.page).subscribe(function (data) {
                _this.receipts = data;
                console.log(data);
                mySearchbar.disabled = false;
            }, function (error) {
                mySearchbar.disabled = false;
                _this.errorMsg = error;
            });
        }
    };
    TestComponent.prototype.generateReceipt = function () {
        console.log("viewEmployee");
        this.router.navigateByUrl('/receiptRegister');
    };
    TestComponent.prototype.viewEmployee = function () {
        console.log("viewEmployee");
        this.router.navigateByUrl('/viewEmployees');
    };
    TestComponent.prototype.registerNewUser = function () {
        console.log("Register");
        this.router.navigateByUrl('/register');
    };
    TestComponent.prototype.logout = function () {
        this._databaseService.logoutUser();
        console.log("LogOut");
    };
    TestComponent.prototype.onAprove = function (receipt) {
        receipt.status = 1;
        this._databaseService.postReinbursementRequest(receipt.id, receipt.status).subscribe(function (data) {
            console.log(data);
        }, function (error) { });
    };
    TestComponent.prototype.onDeny = function (receipt) {
        receipt.status = 2;
        this._databaseService.postReinbursementRequest(receipt.id, receipt.status).subscribe(function (data) {
            console.log(data);
        }, function (error) { });
        console.log("denied " + receipt.id);
    };
    TestComponent.prototype.onChange = function (receipt) {
        receipt.status = 0;
        this._databaseService.postReinbursementRequest(receipt.id, receipt.status).subscribe(function (data) {
            console.log(data);
        }, function (error) { });
        console.log("changed " + receipt.id);
    };
    TestComponent.prototype.checkboxIsClicked = function (myCheckbox) {
        var _this = this;
        myCheckbox.checked = !myCheckbox.checked;
        this.getApproved = myCheckbox.checked;
        this._databaseService.getReceipts(this.page, this.getApproved).subscribe(function (data) { return _this.receipts = data; }, function (error) { return _this.errorMsg = error; });
    };
    TestComponent.prototype.onPreviousPage = function () {
        var _this = this;
        if (this.page > 0) {
            this.page--;
        }
        this._databaseService.getReceipts(this.page, this.getApproved).subscribe(function (data) { return _this.receipts = data; }, function (error) { return _this.errorMsg = error; });
    };
    TestComponent.prototype.onNextPage = function () {
        var _this = this;
        this.page++;
        this._databaseService.getReceipts(this.page, this.getApproved).subscribe(function (data) { return _this.receipts = data; }, function (error) { return _this.errorMsg = error; });
    };
    TestComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-test',
            template: __webpack_require__("./src/app/test/test.component.html"),
            styles: [__webpack_require__("./src/app/test/test.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__database_getter_service__["a" /* DatabaseGetterService */],
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* Router */]])
    ], TestComponent);
    return TestComponent;
}());



/***/ }),

/***/ "./src/app/view-employee/view-employee.component.css":
/***/ (function(module, exports) {

module.exports = "\r\n#receiptContainer {\r\n\tdisplay:block;\r\n\tposition:absolute;\r\n\tleft:33%;\r\n\twidth:33%;\r\n\tmin-width:400px;\r\n}\r\n"

/***/ }),

/***/ "./src/app/view-employee/view-employee.component.html":
/***/ (function(module, exports) {

module.exports = "<nav class=\"navbar navbar-dark bg-dark\">\n  <a class=\"navbar-brand\" (click)=\"logout(); false\" href=\"#\" >Log Out</a>\n  <a class=\"navbar-brand\" id=\"register\" (click)=\"registerNewUser(); false\" href=\"#\" >Register New Employee</a>\n  <a class=\"navbar-brand\" id=\"back\" (click)=\"back(); false\" href=\"#\" >Back</a>\n</nav>\n<div id=\"receiptContainer\" class=\"align-items-center\">\n\t{{errorMsg}}\n\t<div *ngFor=\"let employee of employees\">\n\t\t<span> {{employee.employee.fname}} {{employee.employee.lname}} : {{employee.employee.email}}</span>\n\t</div>\n\t<br/>\n<button (click)=\"onPreviousPage()\" style=\"left:33%\" type=\"button\" class=\"btn btn-primary\">Previous Page</button>\n<span>Page Number:{{this.page}}</span>\n<button (click)=\"onNextPage()\" type=\"button\" class=\"btn btn-primary right\">Next Page</button>\n</div>"

/***/ }),

/***/ "./src/app/view-employee/view-employee.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ViewEmployeeComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__database_getter_service__ = __webpack_require__("./src/app/database-getter.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ViewEmployeeComponent = /** @class */ (function () {
    function ViewEmployeeComponent(_databaseService, router) {
        this._databaseService = _databaseService;
        this.router = router;
        this.employees = [];
        this.page = 0;
    }
    ViewEmployeeComponent.prototype.ngOnInit = function () {
        var _this = this;
        this._databaseService.getEmployees(this.page).subscribe(function (data) {
            _this.employees = data;
            console.log(data);
        }, function (error) { return _this.errorMsg = error; });
    };
    ViewEmployeeComponent.prototype.onPreviousPage = function () {
        var _this = this;
        if (this.page > 0) {
            this.page--;
        }
        this._databaseService.getEmployees(this.page).subscribe(function (data) {
            _this.employees = data;
            console.log(data);
        }, function (error) { return _this.errorMsg = error; });
    };
    ViewEmployeeComponent.prototype.onNextPage = function () {
        var _this = this;
        this.page++;
        this._databaseService.getEmployees(this.page).subscribe(function (data) {
            _this.employees = data;
            console.log(data);
        }, function (error) { return _this.errorMsg = error; });
    };
    ViewEmployeeComponent.prototype.registerNewUser = function () {
        console.log('register');
        this.router.navigateByUrl('/register');
    };
    ViewEmployeeComponent.prototype.back = function () {
        console.log("Back");
        this.router.navigateByUrl('/main');
    };
    ViewEmployeeComponent.prototype.logout = function () {
        this._databaseService.logoutUser();
        console.log("LogOut");
    };
    ViewEmployeeComponent.prototype.viewEmployee = function () {
        console.log("ViewEmployee");
    };
    ViewEmployeeComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-view-employee',
            template: __webpack_require__("./src/app/view-employee/view-employee.component.html"),
            styles: [__webpack_require__("./src/app/view-employee/view-employee.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__database_getter_service__["a" /* DatabaseGetterService */],
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* Router */]])
    ], ViewEmployeeComponent);
    return ViewEmployeeComponent;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
var environment = {
    production: false
};


/***/ }),

/***/ "./src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("./node_modules/@angular/platform-browser-dynamic/esm5/platform-browser-dynamic.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("./src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("./src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_13" /* enableProdMode */])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("./src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map