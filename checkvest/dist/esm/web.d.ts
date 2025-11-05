import { WebPlugin } from '@capacitor/core';
import type { CheckVestPlugin } from './definitions';
export declare class CheckVestWeb extends WebPlugin implements CheckVestPlugin {
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
}
