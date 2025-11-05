import { WebPlugin } from '@capacitor/core';

import type { CheckVestPlugin } from './definitions';

export class CheckVestWeb extends WebPlugin implements CheckVestPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
