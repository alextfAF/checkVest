import { WebPlugin } from '@capacitor/core';
export class CheckVestWeb extends WebPlugin {
    async echo(options) {
        console.warn('CheckVest.echo() called on web');
        return options;
    }
    async checkHasVest(_) {
        console.warn('CheckVest.checkHasVest() called on web (not implemented)');
        return { hasVest: false };
    }
}
//# sourceMappingURL=web.js.map