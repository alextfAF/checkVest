export interface CheckVestPlugin {
  /**
   * Simple echo test.
   */
  echo(options: { value: string }): Promise<{ value: string }>;

  /**
   * Runs vest detection on a Base64 image.
   */
  checkHasVest(options: {
    imageBase64: string;
    showLogs?: boolean;
  }): Promise<{ hasVest: boolean }>;
}