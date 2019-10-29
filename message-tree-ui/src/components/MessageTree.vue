<template>
    <div id="messageBoard" class="container">
        <h2>Message Tree Board</h2>
        <div class="container">
            <table class="table">
                <thead>
                    Message
                </thead>
                <tbody>
                    <tr v-for="msg in messages" v-bind:key="msg.id">
                        <td>{{msg.content}}</td>
                        <td>{{msg.timestamp}}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script>
    import api from './backend-api';
    export default {
        name: "MessageTree",
        props: ['messages'],
        data() {
            return this.messages = [];
        },
        created(){
            this.messages = this.allMessages();
        },
        methods : {
            allMessages()
            {
                api.getAll()
                    .then(response => {
                        this.messages = response.data
                    })
                    .catch(err => {
                        return err;
                    })
                    .finally(() => this.loading = false);
            },

        }
    }

</script>

<style scoped>

</style>
