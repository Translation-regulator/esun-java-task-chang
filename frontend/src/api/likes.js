import axios from 'axios'

const api = axios.create({
  baseURL: '/api/likes'
})

export const getLikes = () => api.get()
export const createLike = (data) => api.post('', data)
export const deleteLike = (sn) => api.delete(`/${sn}`)
export const updateLike = (sn, data) => api.put(`/${sn}`, data)
