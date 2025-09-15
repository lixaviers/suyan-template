const tokenKey = 'Suyan-Token';
export function getToken() {
  return localStorage.getItem(tokenKey);
}
export function setToken(token) {
  localStorage.setItem(tokenKey, token);
}
export function removeToken() {
  return localStorage.removeItem(tokenKey);
}

const SidebarOpenKey = 'SidebarOpen';
export function getSidebarOpenCache() {
  return localStorage.getItem(SidebarOpenKey) !== 'false';
}
export function setSidebarOpenCache(val) {
  localStorage.setItem(SidebarOpenKey, val);
}
