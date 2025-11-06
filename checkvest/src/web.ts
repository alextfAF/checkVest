import { WebPlugin } from '@capacitor/core';
import type { CheckVestPlugin } from './definitions';

export class CheckVestWeb extends WebPlugin implements CheckVestPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.warn('CheckVest.echo() called on web');
    return options;
  }

  async checkHasVest(_: { imageBase64: string; showLogs?: boolean }): Promise<{ hasVest: boolean }> {
    console.warn('CheckVest.checkHasVest() called on web (not implemented)');
    return { hasVest: false };
  }
}