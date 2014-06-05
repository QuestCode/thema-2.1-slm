app.models.Model = function(doc, schema, collection) {
	this.schema = schema;
	this.collection = collection;
	this.context = this.schema.newContext();

	this.name = this.collection._name;

	if(typeof doc === 'undefined') {
		this.hasDoc = false;
	}
	else {
		this.hasDoc = true;
		this.setDoc(doc);
	}
}

app.models.Model.prototype.getDoc = function() {
  var firstLevelSchemaKeys = this.schema.firstLevelSchemaKeys();
  var doc = {};

  for(var i = 0; i < firstLevelSchemaKeys.length; i++) {
    var key = firstLevelSchemaKeys[i];

    if(typeof this[key] !== 'undefined') {
      doc[key] = this[key];
    }
  }

  return doc;
}

app.models.Model.prototype.setDoc = function(doc) {
  var firstLevelSchemaKeys = this.schema.firstLevelSchemaKeys();

  for(var key in doc) {
    var value = doc[key];

    if(firstLevelSchemaKeys.indexOf(key) !== -1) {
      this[key] = value;
    }
  }
}


// Shim for older browser which may not have support for Object.create
// Crockford's Javascript: The Good Parts.
if(typeof Object.create === 'undefined')
{
  Object.create = function(o) {
    function F() {}
    F.prototype = o;
    return new F();
  }
}