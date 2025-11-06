# checkvest

Validate if a person in an image is wearing a vest using TensorFlow Lite

## Install

```bash
npm install checkvest
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`checkHasVest(...)`](#checkhasvest)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

Simple echo test.

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### checkHasVest(...)

```typescript
checkHasVest(options: { imageBase64: string; showLogs?: boolean; }) => Promise<{ hasVest: boolean; }>
```

Runs vest detection on a Base64 image.

| Param         | Type                                                      |
| ------------- | --------------------------------------------------------- |
| **`options`** | <code>{ imageBase64: string; showLogs?: boolean; }</code> |

**Returns:** <code>Promise&lt;{ hasVest: boolean; }&gt;</code>

--------------------

</docgen-api>
