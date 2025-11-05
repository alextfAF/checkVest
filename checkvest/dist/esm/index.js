import { registerPlugin } from '@capacitor/core';
const CheckVest = registerPlugin('CheckVest', {
    web: () => import('./web').then((m) => new m.CheckVestWeb()),
});
export * from './definitions';
export { CheckVest };
//# sourceMappingURL=index.js.map