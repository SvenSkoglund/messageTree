<template>
    <div id="messageBoard">
        <h2>Message Tree Board</h2>
        <div>
            {{messages}}
        </div>
    </div>
</template>

<script>
    import api from './backend-api';
    export default {
        el: "messageBoard",
        name: "MessageTree",
        data() {
            return this.messages = this.allMessages();
        },
        created(){
            this.allMessages();
        },
        methods : {
            allMessages()
            {
                api.getAll()
                    .then(response => {
                        this.$log.debug("Data loaded: ", response.data)
                        this.messages = response.data
                    })
                    .catch(err => {
                        this.$log.debug(err)
                        this.err = "Failed to load messages"
                    })
                    .finally(() => this.loading = false);
            },

        }
    }

</script>

<style scoped>

</style>
