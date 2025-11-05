import { registerPlugin } from '@capacitor/core';

import type { CheckVestPlugin } from './definitions';

const CheckVest = registerPlugin<CheckVestPlugin>('CheckVest', {
  web: () => import('./web').then((m) => new m.CheckVestWeb()),
});

export * from './definitions';
export { CheckVest };
