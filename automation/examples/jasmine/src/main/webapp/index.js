describe("test suite - Hello world", function() {

	it("test 1", function() {
		expect(true).toBe(true);
	});

	it("test 2", function() {
		expect(true).toBe(false);
	});
});

describe("suite  - 2.0", function() {
	var s = 2000;
	it("test1 in suite 2.0", function() {
		expect(s).not.toEqual(100);
	});
	describe("suite  - 3.0", function() {
		var s = 2000;
		it("test1 in suite 3.1", function() {
			expect(s).not.toEqual(100);
		});
		describe("suite  - 4.0", function() {
			var s = 2000;
			it("test1 in suite 4.0", function() {
				expect(s).not.toEqual(100);
			});
			describe("suite  - 5.0", function() {
				var s = 2000;
				it("test1 in suite 5.0", function() {
					expect(s).not.toEqual(100);
				});
				describe("suite  - 6.0", function() {
					var s = 2000;
					it("test1 in suite 6.0", function() {
						expect(s).not.toEqual(100);
					});
					describe("suite  - 7.0", function() {
						var s = 2000;
						it("test1 in suite 7.0", function() {
							expect(s).not.toEqual(100);
						});
						describe("suite  - 8.0", function() {
							var s = 2000;
							it("test1 in suite 8.0", function() {
								expect(s).not.toEqual(100);
							});
							describe("suite  - 9.0", function() {
								var s = 2000;
								it("test1 in suite 9.0", function() {
									expect(s).not.toEqual(100);
								});
							});
						});
					});
				});
			});
			describe("suite - 10.0", function() {

				it("test 1 - 10.0", function() {
					expect(true).toBe(true);
				});

				it("test 2 - 10.0", function() {
					expect(true).toBe(false);
				});
			});			
		});
	});
});

describe("A suite is a function", function() {
	var a = 10;
	it("spec is the same thing", function() {
		expect(a).toEqual(10);
	});
});

describe("Name of the suite goes here", function() {
	var a = 10;
	it("name of the test goes here", function() {
		expect(a).toEqual(10);
	});
});
