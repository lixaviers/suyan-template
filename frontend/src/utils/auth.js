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
