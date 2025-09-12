/**
 * 判断是否为外链
 */
export function isExternal(path) {
  const reg = /^(https?:|mailto:|tel:)/;
  return reg.test(path);
}
