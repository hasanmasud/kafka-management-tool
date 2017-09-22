/* global Handlebars, Mustache, Polymer */

(function() {
  "use strict";
  window.addEventListener("WebComponentsReady", function() {
    Polymer({
      is:         "rest-template",
      properties: {
        src: {
          type: String
        },
        engine: {
          type:  String,
          value: "handlebars"
        }
      },
      ready: function() {
        const self = this,
              contentRoot = Polymer.dom(self),
              templateElement = contentRoot.querySelector("template");
        let template;

        if (templateElement === null) { // Not surrounded by <template></template>
          template = contentRoot.innerHTML;
        } else { // Surrounded by <template></template>
          template = templateElement.innerHTML;
        }

        fetch(self.src).then(function(res) {
          return res.json();
        }).then(function(json) {
          // TODO sort function

          if (!self.engine || self.engine === "handlebars") {
            contentRoot.parentNode.innerHTML = Handlebars.compile(template)(json);
          } else if (self.engine === "mustache") {
            contentRoot.parentNode.innerHTML = Mustache.render(template, json);
          } else {
            return Promise.reject(new Error("Unsupported template engine: " + self.engine));
          }

          self.fire("rendered");
        }).catch(function(err) {
          console.error(err);
        });
      }
    });
  });
}());
