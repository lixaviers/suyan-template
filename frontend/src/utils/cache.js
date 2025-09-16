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

const VisitedViewsKey = 'VisitedViewsKey';
export function getVisitedViewsCache() {
  const cache = localStorage.getItem(VisitedViewsKey);
  if (cache) {
    return JSON.parse(cache);
  }
  return [];
}
export function setVisitedViewsCache(views) {
  localStorage.setItem(VisitedViewsKey, JSON.stringify(views));
}

const CachedViewsKey = 'CachedViewsKey';
export function getCachedViewsCache() {
  const cache = localStorage.getItem(CachedViewsKey);
  if (cache) {
    return JSON.parse(cache);
  }
  return [];
}
export function setCachedViewsCache(views) {
  localStorage.setItem(CachedViewsKey, JSON.stringify(views));
}
