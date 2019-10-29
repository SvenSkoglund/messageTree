import axios from 'axios'

const SERVER_URL = 'http://localhost:8090/api/';

const instance = axios.create({
    baseURL: SERVER_URL,
    timeout: 1000
});

export default {

    createNew: (text, parentId) => instance.post('messages', {message: text, parentId: parentId}),

    getAll: () => instance.get('messages', {
        transformResponse: [function (data) {
            return data? JSON.parse(data)._embedded.todos : data;
        }]
    }),

    updateById: (id, text, parentId) => instance.put('messages/'+id, {message: text, parentId: parentId}),

    removeById: (id) => instance.delete('messages/'+id)
}
