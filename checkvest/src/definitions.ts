export interface CheckVestPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
