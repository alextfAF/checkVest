'use strict';

var core = require('@capacitor/core');

const CheckVest = core.registerPlugin('CheckVest', {
    web: () => Promise.resolve().then(function () { return web; }).then((m) => new m.CheckVestWeb()),
});

class CheckVestWeb extends core.WebPlugin {
    async echo(options) {
        console.log('ECHO', options);
        return options;
    }
}

var web = /*#__PURE__*/Object.freeze({
    __proto__: null,
    CheckVestWeb: CheckVestWeb
});

exports.CheckVest = CheckVest;
//# sourceMappingURL=plugin.cjs.js.map
